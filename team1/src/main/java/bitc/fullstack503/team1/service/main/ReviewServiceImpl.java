package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import bitc.fullstack503.team1.mapper.main.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;


    @Override
    public List<MyReviewBoardDTO> selectDetailReviewCardList(int ucseq) throws Exception {
        return reviewMapper.selectDetailReviewCardList(ucseq);
    }


    // knh

    //목록
    @Override
    public List<MyReviewBoardDTO> selectBoardList() {
        return reviewMapper.selectBoardList();
    }

    //  게시물 상세
    @Override
    public MyReviewBoardDTO selectBoardDetail(int reviewIdx) {
        return reviewMapper.selectBoardDetail(reviewIdx);
    }

    //  게시물 등록
    @Override
    public void insertBoard(MyReviewBoardDTO board) {
        reviewMapper.insertBoard(board);
    }

    //  게시물 수정
    @Override
    public void updateBoard(MyReviewBoardDTO board) {
        reviewMapper.updateBoard(board);
    }

    //  게시물 삭제
    @Override
    public void deleteBoard(int reviewIdx) {
        reviewMapper.deleteBoard(reviewIdx);
    }

    @Override
    public MyReviewBoardDTO selectBoardFileInfo(int reviewImageIdx, int reviewIdx) throws Exception {
        return reviewMapper.selectBoardFileInfo(reviewImageIdx, reviewIdx);
    }
}
