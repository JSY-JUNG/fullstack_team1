package bitc.fullstack503.team1.controller;


import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.service.main.ReviewService;
import bitc.fullstack503.team1.service.main.SearchListService;
import bitc.fullstack503.team1.util.ScriptUtil;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private SearchListService searchListService;
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/SearchList")
    public ModelAndView SearchList(@RequestParam("category") String category, @RequestParam("Keyword") String Keyword, @RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("/main/jsy/SearchList");

        PageInfo<MySpotDTO> SearchListA;
        PageInfo<MyPlaceDTO> SearchListB;

        int result = searchListService.SelectABtype(Keyword, category, pageNum);

        if(result == 1){
            SearchListA = new PageInfo<>(searchListService.SelectPageSearchListA(Keyword,pageNum), 5);
            int countResult = searchListService.SelectCountResult(Keyword);
            mv.addObject("SearchList", SearchListA);
            mv.addObject("countResult", countResult);
        }else{
            SearchListB = new PageInfo<>(searchListService.SelectPageSearchListB(Keyword,pageNum), 5);
            int countResult = searchListService.SelectCountResultB(Keyword);
            mv.addObject("SearchList", SearchListB);
            mv.addObject("countResult", countResult);
        }
        List<MySpotDTO> gugunList = searchListService.selectGugunList();
        mv.addObject("Keyword", Keyword);
        mv.addObject("category", category);
        mv.addObject("gugunList", gugunList);

        if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
            mv.setViewName("main/jsy/itemList :: itemListFragment");
        }

        return mv;
    }

    @GetMapping("/SearchDetail/{UCSEQ}")
    public ModelAndView knh(@PathVariable("UCSEQ") int UCSEQ, @RequestParam("category") String category) throws Exception {
        ModelAndView mv = new ModelAndView("main/knh/spotDetailTest");

        if ("A".equals(category)){
            MySpotDTO spotDetail = searchListService.selectDetailSpot(UCSEQ);
            List<MyReviewBoardDTO> reviewBoard = reviewService.selectDetailReviewCardListA(UCSEQ);
            mv.addObject("Detail", spotDetail);
            mv.addObject("reviewBoard", reviewBoard);
            mv.addObject("category", category);
        }else if("B".equals(category)){
            MyPlaceDTO placeDetail = searchListService.selectDetailPlace(UCSEQ);
            List<MyReviewBoardDTO> reviewBoard = reviewService.selectDetailReviewCardListB(UCSEQ);
            mv.addObject("Detail", placeDetail);
            mv.addObject("reviewBoard", reviewBoard);
            mv.addObject("category", category);
        }

        return mv;
    }

    @PostMapping("/SearchDetail/reviewWrite")
    public void insertReview(MyReviewBoardDTO review, MultipartHttpServletRequest multipart, HttpServletResponse res, String category) throws Exception{

        if("A".equals(category)){
            reviewService.insertReviewA(review, multipart);
            ScriptUtil.alertAndPage(res,"리뷰 작성 성공","/");
        }else if("B".equals(category)){
            reviewService.insertReviewB(review, multipart);
            ScriptUtil.alertAndPage(res,"리뷰 작성 성공","/");
        }
    }
}
