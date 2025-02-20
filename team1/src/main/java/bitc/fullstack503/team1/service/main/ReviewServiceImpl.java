package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
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
}
