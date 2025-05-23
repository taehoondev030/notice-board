package taehoon.board.view.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import taehoon.board.article.domain.Article;
import taehoon.board.article.service.BoardService;
import taehoon.board.view.dto.ArticleListViewResponse;
import taehoon.board.view.dto.ArticleViewResponse;

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

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = boardService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if(id==null) {
            // URL에 id가 없으면 생성 (빈 ArticleViewResponse 객체 생성)
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            // URL에 id가 있으면 수정 (기존 값을 가져오는 findById() 호출)
            Article article = boardService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
