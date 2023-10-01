package dto;

import domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor  // 모든 생성자를 파라미터로 받음
@NoArgsConstructor(force = true)
public class AddArticleRequest {

    private String title;
    private String content;

    // 생성자를 사용해 객체 생성 toEntity()는 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드.
    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }

}
