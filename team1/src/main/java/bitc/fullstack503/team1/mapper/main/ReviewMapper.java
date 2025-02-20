package bitc.fullstack503.team1.mapper.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<MyReviewBoardDTO> selectDetailReviewCardList(int ucseq) throws Exception;
}
