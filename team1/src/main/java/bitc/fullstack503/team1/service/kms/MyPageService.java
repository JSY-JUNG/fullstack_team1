package bitc.fullstack503.team1.service.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.dto.mysql.MyUserDTO;
import com.github.pagehelper.Page;

import java.util.List;

public interface MyPageService {


    MyUserDTO selectMyProfile(String userId) throws Exception;

    Page<MyReviewBoardDTO> selectReviewByUserName(int pageNum, String userId) throws Exception;

    MyReviewBoardDTO selectReviewDetail(String userId, int reviewIdx) throws Exception;

    void updateReview(MyReviewBoardDTO reviews);

    void deleteReview(int reviewIdx);

    List<MySpotDTO> selectMySpot(String userId) throws Exception;

    List<MyPlaceDTO> selectMyPlace(String userId) throws Exception;

    List<MyReviewBoardDTO> selectReviewByManager() throws Exception;
}
