package com.ansim.service;

import com.ansim.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 안심 동행 게시물 목록 보기
    public List<BoardDTO> findList(int startPoint, int endPoint, String keyword) throws Exception;

    // 전체 안심 동행 게시물 갯수 계산
    public int findGetTotalCount(String keyword) throws Exception;

//    // 위도, 경도로부터 주소를 얻는 메서드
//    public String findGetAddress(double latitude, double longitude) throws Exception;

    //게시물 조회수 증가
    public void modifyHitno(int seqno)throws Exception;

    // 출발지 목적지 표기
    public List<BoardDTO> findWrite(String user_id) throws Exception;

    //게시물 등록 하기
    public void modifyWrite(BoardDTO board)throws Exception;

    //게시물 상세 내용 보기
    public BoardDTO findView(int seqno)throws Exception;

    //게시물 내용 이전 보기
    public int findPre_seqno(int seqno, String keyword)throws Exception;

    //게시물 내용 다음 보기
    public int findNext_seqno(int seqno, String keyword)throws Exception;

    //게시물 삭제하기
    public void removeBoard(int seqno)throws Exception;

}
