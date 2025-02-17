package bitc.fullstack503.team1.controller;


import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.service.init.InitService;
import bitc.fullstack503.team1.service.main.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private SpotService spotService;

    @GetMapping("/")
    public String index() {
        return "main/kms/mainPage";
    }

    @GetMapping("/test")
    public ModelAndView test() throws Exception {
        ModelAndView mv = new ModelAndView("page/spot");

        List<MySpotDTO> MySpotList = spotService.SelectMySpotList();
        mv.addObject("MySpotList", MySpotList);
        return mv;
    }

    @GetMapping("/test/{UCSEQ}")
    public ModelAndView test(@PathVariable("UCSEQ") int UCSEQ) throws Exception {
        ModelAndView mv = new ModelAndView("main/jsy/P1");
        MySpotDTO spotDetail = spotService.selectDetail(UCSEQ);
        mv.addObject("spotDetail", spotDetail);
        return mv;
    }

    @GetMapping("/SearchSpotList")
    public ModelAndView SearchSpotList() throws Exception {
        ModelAndView mv = new ModelAndView("main/jsy/SearchSpotList");
        return mv;
    }


}
