package kr.ac.hansung.foodstagram.service;

import kr.ac.hansung.foodstagram.dao.ArticleRepository;
import kr.ac.hansung.foodstagram.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(e -> articles.add(e));

        return articles;
    }

    public Article createArticle(Article article) {

        return articleRepository.save(article);
    }
}
