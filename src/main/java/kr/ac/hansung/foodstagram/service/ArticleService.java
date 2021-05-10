package kr.ac.hansung.foodstagram.service;

import kr.ac.hansung.foodstagram.dao.ArticleRepository;
import kr.ac.hansung.foodstagram.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Article> userProfile(String username) {
        return articleRepository.findByUsername(username);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public List<Article> searchArticle(String keyword) {
        return articleRepository.findByTextContaining(keyword);
    }


}
