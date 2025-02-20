package bitc.fullstack503.team1.controller.knh;

import bitc.fullstack503.team1.dto.mysql.MyReviewBoardDTO;
import bitc.fullstack503.team1.service.main.ReviewService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpotDetailController {
    @Autowired
    private ReviewService reviewService;

    // 명소 상세페이지 테스트 화면
    @GetMapping("/knh")
    public String test2() {
        return "main/knh/spotDetailTest";
    }

    //  게시글 상세 정보 가져오기 API
    @GetMapping("/knh/{reviewIdx}")
    public Object selectBoard(@PathVariable("reviewIdx") int reviewIdx) {
        MyReviewBoardDTO board = reviewService.selectBoardDetail(reviewIdx);

        return board;
    }

    //  게시판 글 등록 API
    @PostMapping("/knh")
    public void insertBoard(MyReviewBoardDTO board)  {
        reviewService.insertBoard(board);
    }
    //  게시판 글 수정 API
    @PutMapping("/knh/{reviewIdx}")
    public void updateBoard(@PathVariable("reviewIdx") int reviewIdx, MyReviewBoardDTO board) {
        board.setReviewIdx(reviewIdx);
        reviewService.updateBoard(board);
    }
    //  게시판 글 삭제 API
    @DeleteMapping("/knh/{reviewIdx}")
    public void deleteBoard(@PathVariable("reviewIdx") int reviewIdx) {
        reviewService.deleteBoard(reviewIdx);
    }

    // 이미지 첨부
//    @RequestMapping("/board/downloadBoardFile.do")
//    public void downloadBoardFile(@RequestParam("reviewImageIdx") int reviewImageIdx, @RequestParam("reviewIdx") int reviewIdx, HttpServletResponse response) throws Exception {
//
//        MyReviewBoardDTO boardFile = reviewService.selectBoardFileInfo(reviewImageIdx, reviewIdx);
//
//        if (ObjectUtils.isEmpty(boardFile) == false) {
//
//            String fileName = boardFile.getOriginalFileName();
//
//            byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFileName()));
//
//
//            response.setContentType("application/octet-stream");
//            response.setContentLength(files.length);
//
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
//
//            response.getOutputStream().write(files);
//            response.getOutputStream().flush();
//            response.getOutputStream().close();
//        }
//    }


}
