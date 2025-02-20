package bitc.fullstack503.team1.mapper.main;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.dto.mysql.ReviewImageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<MyReviewBoardDTO> selectDetailReviewCardList(int ucseq) throws Exception;


    //knh

    List<MyReviewBoardDTO> selectBoardList();

    MyReviewBoardDTO selectBoardDetail(int reviewIdx);

    void insertBoard(MyReviewBoardDTO board);

    void updateBoard(MyReviewBoardDTO board);

    void deleteBoard(int reviewIdx);


    public void insertBoardFileList(List<MyReviewBoardDTO> fileList) throws Exception;
    public MyReviewBoardDTO selectBoardFileInfo(@Param("reviewImageIdx") int reviewImageIdx, @Param("reviewIdx") int reviewIdx) throws Exception;
    public List<MyReviewBoardDTO> selectBoardFileList(@Param("reviewIdx") int reviewIdx) throws Exception;
}
