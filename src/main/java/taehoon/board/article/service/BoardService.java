package taehoon.board.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taehoon.board.article.domain.Article;
import taehoon.board.article.dto.AddArticleRequest;
import taehoon.board.article.dto.UpdateArticleRequest;
import taehoon.board.article.repository.BoardRepository;

import java.util.List;

@RequiredArgsConstructor // final, @NotNull이 붙은 필드 생성자 추가
@Service // 빈으로 등록
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 추가 메서드
    // JpaRepository에서 지원하는 저장(save) 메서드
    public Article save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }

    // DB에 저장된 전체 게시글 조회
    public List<Article> findAll() {
        return boardRepository.findAll();
    }

    // DB에 저장된 1개 게시글 조회
    public Article findById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + id));
    }

    // DB에 저장된 게시글 삭제
    public void delete(long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
