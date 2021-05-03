package kr.ac.hansung.foodstagram.controller;

import kr.ac.hansung.foodstagram.entity.Article;
import kr.ac.hansung.foodstagram.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String rootPage() {
        return "index";
    }

    @GetMapping("/mainfeed")
    public ResponseEntity<?> retrieveAllAricles(){
        final List<Article> articles = articleService.getAllArticles();

        if (articles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }

}
