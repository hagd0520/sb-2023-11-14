package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();
    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
//    Article article;
//    RsData<Article> rs;
//    List<RsData<Article>> rsList = new ArrayList<>();
//    long idNum = 0
//
//    @GetMapping("/article/write")
//    String showWrite() {
//        return "write";
//    }
//
//    @GetMapping("/article/doWrite")
//    @ResponseBody
//    List<RsData<Article>> doWrite(
//            String title,
//            String body
//    ) {
//        article = new Article(
//                ++idNum,
//                title,
//                body
//        );
//
//        rsList.add(rs = new RsData<Article>(
//                "%d".formatted(rsList.size() + 1),
//                ":D",
//                article
//                ));
//
//        return rsList;
//    }
//
//    @GetMapping("/article/getLastArticle")
//    @ResponseBody
//    Article getLastArticle() {
//        return articleList.get(articleList.size() - 1);
//    }
//
//    @GetMapping("/article/getArticles")
//    @ResponseBody
//    RsData<Article> getArticles() {
//
//    }
}

@AllArgsConstructor
@Getter
class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
}