package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import com.github.pagehelper.Page;

import java.util.List;

public interface SpotService {
    List<MySpotDTO> SelectMySpotList() throws Exception;

    MySpotDTO selectDetail(int ucseq) throws Exception;

    List<MySpotDTO> SelectSearchList(String keyword, int pageNum) throws Exception;

    Page<MySpotDTO> SelectPageSearchList(String keyword, int pageNum) throws Exception;
}
