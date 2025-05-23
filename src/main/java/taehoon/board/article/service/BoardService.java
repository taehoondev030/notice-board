package taehoon.board.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taehoon.board.article.domain.Article;
import taehoon.board.article.dto.AddArticleRequest;
import taehoon.board.article.repository.BoardRepository;

@RequiredArgsConstructor // final, @NotNull이 붙은 필드 생성자 추가
@Service // 빈으로 등록
public class BoardService {

    private final BoardRepository boardRepository;

    // 블로그 글 추가 메서드
    // JpaRepository에서 지원하는 저장(save) 메서드
    public Article save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }

}
