package bitc.fullstack503.team1.controller.khamro;

import bitc.fullstack503.team1.dto.member.RegisterDTO;
import bitc.fullstack503.team1.service.member.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private RegisterService registerService;

//    회원 가입 페이지 출력 요청
    @RequestMapping("/khamro/register")
    public String register() {
        return "main/khamro/RegisterPage";
    }

//    회원 가입 페이지에서 작성한 내용을 받아준 메소드
    @PostMapping("/khamro/memberReg")
    public String MemberRegister(@ModelAttribute RegisterDTO registerDTO) throws Exception {
        registerService.memberReg(registerDTO);

//        DTO 파일과 연결 확인
        System.out.println("LoginController.MemberRegister");
        System.out.println("registerDTO" + registerDTO);
        return "main/kms/mainPage";
    }

//        id 중복 확인 (ajax)
    @ResponseBody
    @RequestMapping("/khamro/idCheck")
    public boolean idCheck(@RequestParam("userId") String userId) throws Exception {
        return registerService.checkId(userId);
    }








    //  로그인 페이지
    @GetMapping("/khamro")
    public String login() {
        return "main/khamro/LoginPage";
    }

//    로그인 process 페이지
    @RequestMapping("/khamro/loginProcess")
    public String loginProcess(@RequestParam ("userId") String userId, @RequestParam("userPw1") String userPw1, HttpServletRequest request) throws Exception {

        boolean result = registerService.isUserInfo(userId, userPw1);

//        입력한 아이디와 비밀번호가 데이터베이스에 있으면 getUserInfo() 메소드를 이요하여 가져옴
        if(result == true) {
            RegisterDTO login = registerService.getUserInfo(userId);
            HttpSession session = request.getSession();
            session.setAttribute("userId", login.getUserId() );
            session.setAttribute("userPw1", login.getUserPw1());
            session.setMaxInactiveInterval(60);
            return "main/kms/mainPage";
        }
//        입력한 아이디와 비밀번호가 데이터베이스에 없으면
        else {
            System.out.println();
            return "main/khamro/LoginPage";

        }
    }

//    로그아웃 처리
//    @RequestMapping("/khamro/logout")
//    public String logout(HttpServletRequest request) throws Exception {
//        HttpSession session = request.getSession();
//        session.removeAttribute("userId");
//        session.removeAttribute("userPw1");
//
//        session.invalidate();
//        return "main/kms/mainPage";
//    }

//    ID/PW 찾기 페이지
    @RequestMapping("/khamro/logPw")
    public String logPw() throws Exception {
        return "main/khamro/LogPwProcces";
    }



}
