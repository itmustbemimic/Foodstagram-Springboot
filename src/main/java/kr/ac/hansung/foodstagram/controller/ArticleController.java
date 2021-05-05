package kr.ac.hansung.foodstagram.controller;

import com.sun.istack.NotNull;
import kr.ac.hansung.foodstagram.entity.Article;
import kr.ac.hansung.foodstagram.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/mainfeed")
    public ResponseEntity<?> retrieveAllAricles(){
        final List<Article> articles = articleService.getAllArticles();

        if (articles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }


    @PostMapping("/mainfeed")
    public ResponseEntity<Article> createFeed(@RequestBody Article request) {
        Article article = articleService.createArticle(
                request.getUsername(),
                request.getRating(),
                request.getCalorie(),
                request.getImg_path(),
                request.getRestaurant_id()
                );

        return new ResponseEntity<Article>(article, HttpStatus.CREATED);
    }


}
