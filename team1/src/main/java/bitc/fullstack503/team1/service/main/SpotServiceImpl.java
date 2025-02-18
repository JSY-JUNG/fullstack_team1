package bitc.fullstack503.team1.service.main;

import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import bitc.fullstack503.team1.mapper.main.SpotMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    @Autowired
    private SpotMapper spotMapper;

    @Override
    public List<MySpotDTO> SelectMySpotList() throws Exception {
        return spotMapper.SelectMySpotList();
    }

    @Override
    public MySpotDTO selectDetail(int ucseq) throws Exception {
        return spotMapper.selectDetail(ucseq);
    }

    @Override
    public List<MySpotDTO> SelectSearchList(String keyword, int pageNum) throws Exception {
        return spotMapper.SelectSearchList(keyword);
    }

    @Override
    public Page<MySpotDTO> SelectPageSearchList(String keyword, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        Page<MySpotDTO> Spot = spotMapper.selectPageSearchList(keyword);

        return Spot;
    }
}
