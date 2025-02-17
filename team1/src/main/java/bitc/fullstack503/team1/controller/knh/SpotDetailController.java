package bitc.fullstack503.team1.controller.knh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpotDetailController {
    // 명소 상세페이지 테스트 화면
    @GetMapping("/knh")
    public String test2() {
        return "main/knh/spotDetailTest";
    }
}
