package bitc.fullstack503.team1.controller.kms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/kms")
    public String mainPage() {
        return "main/kms/mainPage";
    }
}
