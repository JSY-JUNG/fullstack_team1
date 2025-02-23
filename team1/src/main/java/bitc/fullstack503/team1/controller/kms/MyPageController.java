package bitc.fullstack503.team1.controller.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.dto.mysql.MyUserDTO;
import bitc.fullstack503.team1.service.kms.MyPageService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyPageController {


    @Autowired
    private MyPageService myPageService;

    @GetMapping("/MyPage")
    public ModelAndView selectMyPage(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView("main/kms/myPage");

        // 세션에서 로그인한 유저 정보 가져오기(세션보는 오브젝트 타입이라 형변환)
        String userId = (String) session.getAttribute("userId");

        // 해당 유저의 정보를 가져오기
        MyUserDTO profile = myPageService.selectMyProfile(userId);

        // 관리자의 모든 유저의 리뷰 가져오기
        List<MyReviewBoardDTO> reviewsAll = myPageService.selectReviewByManager();

        // 해당 유저가 작성한 리뷰 목록 가져오기
        PageInfo<MyReviewBoardDTO> reviews = new PageInfo<>(myPageService.selectReviewByUserName(pageNum, userId), 5);

        // 해당 유저가 즐찾한 명소
        List<MySpotDTO> mySpot = myPageService. selectMySpot(userId);
        // 해당 유저가 즐찾한 맛집
        List<MyPlaceDTO> myPlace = myPageService. selectMyPlace(userId);

        // 뷰에 데이터 전달
        mav.addObject("userId", userId);
        mav.addObject("profile", profile);
        mav.addObject("reviews", reviews);
        mav.addObject("reviewsAll", reviewsAll);
        mav.addObject("mySpot", mySpot);
        mav.addObject("myPlace", myPlace);

        return mav;
    }

//    리뷰 상세 페이지
    @RequestMapping(value = "/MyPage/{reviewIdx}", method = RequestMethod.GET)
    public ModelAndView selectBoardDetail(@PathVariable("reviewIdx") int reviewIdx, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView("main/kms/myPageSection/myReviewDetail");

        String userId = (String) session.getAttribute("userId");

        MyReviewBoardDTO review = myPageService.selectReviewDetail(userId, reviewIdx);

        mav.addObject("review", review);

        return mav;
    }

    //    리뷰 수정
    @PutMapping("/MyPage/{reviewIdx}")
    public String updateBoard(MyReviewBoardDTO reviews) throws Exception {
        myPageService.updateReview(reviews);

        return "redirect:/MyPage";
    }

    //    리뷰 삭제
    @DeleteMapping("/MyPage/{reviewIdx}")
    public String deleteBoard(@PathVariable("reviewIdx") int reviewIdx) throws Exception {
        myPageService.deleteReview(reviewIdx);

        return "redirect:/MyPage";
    }



}
