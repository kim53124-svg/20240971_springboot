package com.example.demo.controller;

import com.example.demo.model.domain.Board;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/board_list")
    public String board_list(Model model,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "") String keyword,
                             HttpSession session) {

        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        if (userId == null) {
            return "redirect:/member_login";
        }

        PageRequest pageable = PageRequest.of(page, 3); 
        Page<Board> list;
        if (keyword.isEmpty()) {
            list = blogService.findAll(pageable);
        } else {
            list = blogService.searchByKeyword(keyword, pageable);
        }

        model.addAttribute("boards", list);
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("email", email);
        return "board_list";
    }

    @GetMapping("/board_write")
    public String board_write() {
        return "board_write"; // templates/board_write.html 파일과 연결
    }

    @PostMapping("/api/boards")
    public String addboards(@ModelAttribute AddArticleRequest request) {
        blogService.save(request);
        return "redirect:/board_list";
    }

    @GetMapping("/board_view/{id}") // 게시판 상세 페이지 링크 지정
    public String board_view(Model model, @PathVariable Long id) {
        // 서비스 계층을 통해 ID로 게시글 조회
        Optional<Board> list = blogService.findById(id);

        if (list.isPresent()) {
            // 게시글이 존재하면 모델에 담아 뷰로 전달
            model.addAttribute("boards", list.get());
        } else {
            // 게시글이 없을 경우 에러 페이지로 이동 (자료 기준)
            return "/error_page/article_error";
        }
        return "board_view"; // board_view.html 파일 연결
    }

    @GetMapping("/board_view/{id}")
    public String board_view(Model model, @PathVariable Long id) {
        Optional<Board> list = blogService.findById(id);
        if (list.isPresent()) {
            model.addAttribute("boards", list.get());

            // model.addAttribute("board", list.get());
        } else {

            return "/error_page/article_error";
        }
        return "board_view";
    }

    @GetMapping("/board_edit/{id}") // 수정 페이지 연결
    public String board_edit(@PathVariable Long id, Model model) {
        Optional<Board> board = blogService.findById(id); // 기존 글 조회
        if (board.isPresent()) {
            model.addAttribute("board", board.get());
        }
        return "board_edit"; // board_edit.html 연결
    }

    @PutMapping("/api/board_edit/{id}")
    public String updateBoard(@PathVariable Long id, @ModelAttribute AddArticleRequest request) {
        blogService.update(id, request); // 서비스의 수정 메서드 호출
        return "redirect:/board_list"; // 수정 후 목록으로 이동
    }
}
