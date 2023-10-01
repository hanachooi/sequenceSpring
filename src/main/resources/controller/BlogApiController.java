package controller;

import domain.Article;
import dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.BlogService;

@RestController
@RequiredArgsConstructor // @NotNull
public class BlogApiController {

    // 어노테이션을 RestController 로 정하였는데, 이는 아래의 객체인 blogService 를 JSON 형식으로 반환을 함.
    private final BlogService blogService;

    @PostMapping("/api/articles")       // /api/articles 라는 url은 addArticle() 메서드에 매핑.
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        // RequestBody 라는 어노테이션은 HTTP 요청을 할 떄 응답값을 AddArticleRequest 에 매핑을 하고 있어.
        Article savedArticle = blogService.save(request);       // 요청을 받아서 savedArticle 에 저장.

        // 저장된 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }


}
