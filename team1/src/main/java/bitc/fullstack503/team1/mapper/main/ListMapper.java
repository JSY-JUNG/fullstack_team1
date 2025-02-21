package bitc.fullstack503.team1.mapper.main;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListMapper {

    MySpotDTO selectDetailSpot(int ucseq) throws Exception;

    Page<MySpotDTO> selectPageSearchListA(String keyword) throws Exception;

    Page<MyPlaceDTO> selectPageSearchListB(String keyword) throws Exception;

    List<MySpotDTO> selectGugunList() throws Exception;

    MyPlaceDTO selectDetailPlace(int ucseq) throws Exception;
}
