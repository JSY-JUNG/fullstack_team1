package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;

import java.util.List;

public interface ReviewService {
    List<MyReviewBoardDTO> selectDetailReviewCardList(int ucseq) throws Exception;


    //knh

    //  게시물 목록
    List<MyReviewBoardDTO> selectBoardList();

    //  게시물 상세
    MyReviewBoardDTO selectBoardDetail(int reviewIdx);

    //  게시물 등록
    void insertBoard(MyReviewBoardDTO board);

    //  게시물 수정
    void updateBoard(MyReviewBoardDTO board);

    //  게시물 삭제
    void deleteBoard(int reviewIdx);


    public MyReviewBoardDTO selectBoardFileInfo(int reviewImageIdx, int reviewIdx) throws Exception;
}
