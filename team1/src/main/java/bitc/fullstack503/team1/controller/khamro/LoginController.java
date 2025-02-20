package bitc.fullstack503.team1.controller.khamro;

import bitc.fullstack503.team1.dto.member.RegisterDTO;
import bitc.fullstack503.team1.service.member.RegisterService;
import bitc.fullstack503.team1.util.ScriptUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private RegisterService registerService;

//    회원 가입 페이지 출력 요청
    @GetMapping("/khamro/register")
    public String register() {
        return "main/khamro/RegisterPage";
    }

//    회원 가입 페이지에서 작성한 내용을 받아준 메소드
    @PostMapping("/khamro/memberReg")
    public void MemberRegister(RegisterDTO registerDTO, HttpServletResponse res) throws Exception {
        registerService.memberReg(registerDTO);
        ScriptUtil.alertAndPage(res, "회원가입 성공", "/");
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
    public void loginProcess(@RequestParam ("userId") String userId, @RequestParam("userPw1") String userPw1, HttpServletRequest req, HttpServletResponse res) throws Exception {

        boolean result = registerService.isUserInfo(userId, userPw1);

//        입력한 아이디와 비밀번호가 데이터베이스에 있으면 getUserInfo() 메소드를 이요하여 가져옴
        if(result == true) {
            RegisterDTO login = registerService.getUserInfo(userId);
            HttpSession session = req.getSession();
            session.setAttribute("userId", login.getUserId());
            session.setAttribute("userName", login.getUserName());
//            session.setAttribute("userPw1", login.getUserPw1());
            session.setMaxInactiveInterval(60);
            ScriptUtil.alertAndPage(res,"로그인 성공","/");
        }
//        입력한 아이디와 비밀번호가 데이터베이스에 없으면
        else {
            ScriptUtil.alertAndPage(res,"ID/PW 정보가 다릅니다.","/khamro");
        }
    }

    // 로그아웃 처리
    @RequestMapping("/khamro/logout")
    public void logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");

        session.invalidate();
        ScriptUtil.alertAndPage(res,"로그아웃 되었습니다.","/");
    }

//    ID/PW 찾기 페이지
    @RequestMapping("/khamro/logPw")
    public String logPw() throws Exception {
        return "main/khamro/LogPwProcces";
    }



}
