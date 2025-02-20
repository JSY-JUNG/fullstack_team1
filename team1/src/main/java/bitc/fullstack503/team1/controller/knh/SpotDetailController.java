package bitc.fullstack503.team1.controller.knh;

import bitc.fullstack503.team1.service.main.SearchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpotDetailController {

    @Autowired
    private SearchListService searchListService;

    // 명소 상세페이지 테스트 화면
    @GetMapping("/knh")
    public ModelAndView spotDetail() {
        ModelAndView mv = new ModelAndView("main/knh/spotDetailTest");
//        MySpotDTO SpotDetail = spotService.selectDetail()
        return mv;
    }
}
