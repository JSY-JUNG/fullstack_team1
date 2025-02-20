package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;

import java.util.List;

public interface ReviewService {
    List<MyReviewBoardDTO> selectDetailReviewCardList(int ucseq) throws Exception;
}
