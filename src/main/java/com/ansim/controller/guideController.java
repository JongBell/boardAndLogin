package com.ansim.controller;

        import com.ansim.dto.CctvDTO;
        import com.ansim.dto.DeliboxDTO;
        import com.ansim.dto.EmergbellDTO;
        import com.ansim.service.MarkerService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;

        import java.util.List;

@Controller
@RequiredArgsConstructor
public class guideController {

    private final MarkerService service;

//    @GetMapping("member/login")
//    public void getLogin() throws Exception {
//
//    }

    //도착지 출발지 설정 정리해서 marker랑 합칠 예정
    @GetMapping("/guide/map")
    public void getMap(){}

    // test ~ test2 뭔가 할려고 만들었는데... 뭘 위해서 만들었었는지 기억이 안남...
    // 시간 날 때 뭘 할려고 했었는지 정리해서 없앨거 없애고 합칠거 합치겠음.
    //test
    @GetMapping("/guide/test")
    public void getTest(){}

    //test1
    @GetMapping("/guide/test1")
    public void getTest1(){}

    //지정된 범위 안 마커 표기 map 정리되면 map이랑 합칠 예정
    @GetMapping("/guide/marker")
    public void getMarker(Model model) throws Exception {

//        List<CctvDTO> cctvList = service.cctv();
//        List<EmergbellDTO> emergbellList = service.emergbell();
//        List<DeliboxDTO> deliboxList = service.delibox();

//        for (CctvDTO obj : cctvList) {
//            System.out.println("Latitude: " + obj.getLatitude() + ", Longitude: " + obj.getLongitude());
//        }
//        for (EmergbellDTO obj : emergbellList) {
//            System.out.println("Latitude: " + obj.getLatitude() + ", Longitude: " + obj.getLongitude());
//        }
//        for (DeliboxDTO obj : deliboxList) {
//            System.out.println("Latitude: " + obj.getLatitude() + ", Longitude: " + obj.getLongitude());
//        }


        model.addAttribute("cctv", service.cctv());
        model.addAttribute("delibox", service.delibox());
        model.addAttribute("emergbell", service.emergbell());
//        System.out.println(service.cctv());
//        System.out.println(service.delibox());
//        System.out.println(service.emergbell());
    }
}

