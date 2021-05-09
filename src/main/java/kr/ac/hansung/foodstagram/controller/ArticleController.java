package kr.ac.hansung.foodstagram.controller;

import com.sun.istack.NotNull;
import kr.ac.hansung.foodstagram.entity.Article;
import kr.ac.hansung.foodstagram.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/mainfeed")
    public ResponseEntity<?> retrieveAllArticles(){
        final List<Article> articles = articleService.getAllArticles();

        if (articles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }


    @PostMapping("/mainfeed")
    public ResponseEntity<Article> createFeed(@RequestBody Article request) {
        Article article = articleService.createArticle(request);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/mainfeed/{username}")
    public ResponseEntity<?> userProfile(@PathVariable String username){
        List<Article> articles = articleService.userProfile(username);

        return new ResponseEntity<>(articles, HttpStatus.OK);

    }

    @DeleteMapping("/mainfeed/{article_id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long article_id) {
        articleService.deleteArticle(article_id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
