package bitc.fullstack503.team1.controller.khamro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    //  로그인 페이지 (View)
    @GetMapping("/khamro")
    public String login() {
        return "main/khamro/LoginPage";
    }

//    회원 가입
    @RequestMapping("/khamro/register")
    public String register() {
        return "main/khamro/RegisterPage";
    }

}
