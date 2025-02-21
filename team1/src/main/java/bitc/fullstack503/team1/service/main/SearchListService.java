package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import com.github.pagehelper.Page;

import java.util.List;

public interface SearchListService {

    MySpotDTO selectDetailSpot(int ucseq) throws Exception;

    int SelectABtype(String keyword, String category, int pageNum) throws Exception;

    Page<MySpotDTO> SelectPageSearchListA(String keyword, int pageNum) throws Exception;

    Page<MyPlaceDTO> SelectPageSearchListB(String keyword, int pageNum) throws Exception;


    List<MySpotDTO> selectGugunList() throws Exception;

    MyPlaceDTO selectDetailPlace(int ucseq) throws Exception;

}
