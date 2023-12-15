package com.ansim.controller;

import com.ansim.dto.BoardDTO;
import com.ansim.service.BoardService;
import com.ansim.util.Page;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    // 의존성 주입
    private final BoardService service;

    // 안심 동행 게시물 페이지
    @GetMapping("/board/list")
    public void getList(Model model, @RequestParam("page") int pageNum,
                        @RequestParam(name = "keyword", defaultValue = "", required = false) String keyword) throws Exception {

//        System.out.println("yourMethod started");

        int postNum = 6; // 한 화면에 보여지는 게시물 행의 갯수
        int startPoint = (pageNum - 1) * postNum + 1; //페이지 시작 게시물 번호
        int endPoint = pageNum * postNum;
        int pageListCount = 10; // 화면 하단에 보여지는 페이지리스트의 페이지 갯수
        int totalCount = service.findGetTotalCount(keyword); // 전체 게시물 갯수

//        System.out.println(service.findList(startPoint,endPoint,keyword));

//        List<BoardDTO> boardList = service.findList(startPoint,endPoint,keyword);
//
//        for (BoardDTO obj : boardList) {
//            System.out.println(obj.getSeqno());
//            System.out.println(obj.getUser_id());
//            System.out.println("title: " + obj.getTitle());
//            System.out.println("regdate: " + obj.getRegdate());
//            System.out.println("content: " + obj.getContent());
//            System.out.println("options: " + obj.getOptions());
//            System.out.println("departure_LATITUDE: " + obj.getDeparture_LATITUDE());
//            System.out.println("departure_LONGITUDE: " + obj.getDeparture_LONGITUDE());
//            System.out.println("destination_LATITUDE: " + obj.getDestination_LATITUDE());
//            System.out.println("destination_LONGITUDE: " + obj.getDestination_LONGITUDE());
//            System.out.println("MEETING_TIME: " + obj.getMEETING_TIME());
//            System.out.println(obj.getHitno());
//        }

        Page page = new Page();

        model.addAttribute("list", service.findList(startPoint, endPoint, keyword));
        model.addAttribute("totalElement", service.findGetTotalCount(keyword));
        model.addAttribute("postNum", postNum);
        model.addAttribute("page", pageNum);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageList", page.getPageList(pageNum, postNum, pageListCount, totalCount, keyword));


    }

    //게시물 등록 화면 보기 (세션에서 user_id 받아와서, 출발지, 목적지는 화면에 값이 이미 나와있게 되도록)
    @GetMapping("/board/write")
    public void getWriteDetails() throws Exception {

//        HttpSession session, Model model <- 인자 값으로 넣어줘야 함.

//        // userid 세션 값 가져오기
//        String user_id = (String)session.getAttribute("user_id");
//        // 출발지, 목적지 가져오기
//        model.addAttribute("points", service.findWrite(user_id));
    }

    //첨부파일 없는 게시물 등록 하기
    @ResponseBody
    @PostMapping("/board/write")
    public String postWriteAdd(BoardDTO board) throws Exception {
        service.modifyWrite(board);
        return "{\"message\":\"GOOD\"}";
    }

    //게시물 내용 보기
    @GetMapping("/board/view")
    public void getViewDetails(@RequestParam("seqno") int seqno, @RequestParam("page") int pageNum,
                               @RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
                               Model model, HttpSession session) throws Exception {

        String session_userid = (String) session.getAttribute("userid");
        String role = (String) session.getAttribute("role");

        model.addAttribute("view", service.findView(seqno));
        model.addAttribute("page", pageNum);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pre_seqno", service.findPre_seqno(seqno, keyword));
        model.addAttribute("next_seqno", service.findNext_seqno(seqno, keyword));

        // 조회수 증가 (String 비교할때는 equals 사용)
        if (!session_userid.equals(service.findView(seqno).getUser_id())) {
            service.modifyHitno(seqno);
        }
    }

    // 게시물 삭제하기
    @Transactional
    @GetMapping("/board/delete")
    public String getDelete(@RequestParam("seqno")int seqno) throws Exception {
        // transaction 시작
        service.removeBoard(seqno); // 게시물 행 삭제
        // transaction 끝
        return "redirect:/board/list?page=1";
    }

}
