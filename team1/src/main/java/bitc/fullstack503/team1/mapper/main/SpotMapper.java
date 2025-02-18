package bitc.fullstack503.team1.mapper.main;

import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {
    List<MySpotDTO> SelectMySpotList() throws Exception;

    MySpotDTO selectDetail(int ucseq) throws Exception;

    List<MySpotDTO> SelectSearchList(String keyword) throws Exception;

    Page<MySpotDTO> selectPageSearchList(String keyword) throws Exception;
}
