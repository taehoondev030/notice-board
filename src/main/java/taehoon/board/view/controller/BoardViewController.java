package taehoon.board.view.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taehoon.board.article.service.BoardService;
import taehoon.board.view.dto.ArticleListViewResponse;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardViewController {

    private final BoardService boardService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = boardService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 게시물 리스트 저장

        return "articleList"; // articleList.html 조회
    }
}
