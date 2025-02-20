package bitc.fullstack503.team1.controller;


import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.service.main.ReviewService;
import bitc.fullstack503.team1.service.main.SearchListService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private SearchListService searchListService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/test")
    public ModelAndView test() throws Exception {
        ModelAndView mv = new ModelAndView("page/spot");

        List<MySpotDTO> MySpotList = searchListService.SelectMySpotList();
        mv.addObject("MySpotList", MySpotList);
        return mv;
    }

    @GetMapping("/test/{UCSEQ}")
    public ModelAndView test(@PathVariable("UCSEQ") int UCSEQ) throws Exception {
        ModelAndView mv = new ModelAndView("main/jsy/P1");
        MySpotDTO spotDetail = searchListService.selectDetail(UCSEQ);
        mv.addObject("spotDetail", spotDetail);
        return mv;
    }

    @GetMapping("/SearchList")
    public ModelAndView SearchList(@RequestParam("category") String category, @RequestParam("Keyword") String Keyword, @RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("/main/jsy/SearchList");

        PageInfo<MySpotDTO> SearchListA;
        PageInfo<MyPlaceDTO> SearchListB;

        int result = searchListService.SelectABtype(Keyword, category, pageNum);

        if(result == 1){
            SearchListA = new PageInfo<>(searchListService.SelectPageSearchListA(Keyword,pageNum), 5);
            mv.addObject("SearchList", SearchListA);
        }else{
            SearchListB = new PageInfo<>(searchListService.SelectPageSearchListB(Keyword,pageNum), 5);
            mv.addObject("SearchList", SearchListB);
        }
        List<MySpotDTO> gugunList = searchListService.selectGugunList();
        mv.addObject("Keyword", Keyword);
        mv.addObject("category", category);
        mv.addObject("gugunList", gugunList);
        return mv;
    }

    @GetMapping("/knh/{UCSEQ}")
    public ModelAndView knh(@PathVariable("UCSEQ") int UCSEQ) throws Exception {
        ModelAndView mv = new ModelAndView("main/knh/spotDetailTest");
        MySpotDTO spotDetail = searchListService.selectDetail(UCSEQ);
        List<MyReviewBoardDTO> reviewBoard = reviewService.selectDetailReviewCardList(UCSEQ);
        mv.addObject("spotDetail", spotDetail);
        mv.addObject("reviewBoard", reviewBoard);
        return mv;
    }
}
