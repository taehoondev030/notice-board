package taehoon.board.article.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 생성자 위에 입력 시 빌더 패턴으로 객체 생성 가능
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
