package taehoon.board.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import taehoon.board.article.domain.Article;
import taehoon.board.article.dto.AddArticleRequest;
import taehoon.board.article.service.BoardService;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형태로 반환하는 컨트롤러
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/articles")
    // @RequestBody로 요청 본문에 있는 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = boardService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
