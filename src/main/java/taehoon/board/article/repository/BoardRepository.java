package taehoon.board.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taehoon.board.article.domain.Article;

public interface BoardRepository extends JpaRepository<Article, Long> {
}
