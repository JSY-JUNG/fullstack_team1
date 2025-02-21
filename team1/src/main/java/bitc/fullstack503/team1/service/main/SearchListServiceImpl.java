package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.mapper.main.ListMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchListServiceImpl implements SearchListService {

    @Autowired
    private ListMapper listMapper;


    @Override
    public MySpotDTO selectDetailSpot(int ucseq) throws Exception {
        return listMapper.selectDetailSpot(ucseq);
    }


    @Override
    public Page<MySpotDTO> SelectPageSearchListA(String keyword, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        Page<MySpotDTO> Spot = listMapper.selectPageSearchListA(keyword);

        return Spot;
    }

    @Override
    public Page<MyPlaceDTO> SelectPageSearchListB(String keyword, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        Page<MyPlaceDTO> Place = listMapper.selectPageSearchListB(keyword);

        return Place;
    }

    @Override
    public List<MySpotDTO> selectGugunList() throws Exception {
        return listMapper.selectGugunList();
    }

    @Override
    public MyPlaceDTO selectDetailPlace(int ucseq) throws Exception {
        return listMapper.selectDetailPlace(ucseq);
    }

    @Override
    public int SelectABtype(String keyword, String category, int pageNum) throws Exception {

        int result;

        if("A".equals(category)){
            result = 1;
        }else if("B".equals(category)){
            result = 2;
        }else{
            result = 1;
        }

        return result;
    }
}
