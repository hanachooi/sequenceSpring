package service;

import domain.Article;
import dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import respository.BlogRepository;

@RequiredArgsConstructor  // final이 붙거나 @NotNull이 붙은 아래의 blogReposiotry 라는 객체를 빈에다가 주입.
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }



}
