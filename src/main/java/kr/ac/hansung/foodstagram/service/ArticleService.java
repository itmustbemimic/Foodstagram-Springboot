package kr.ac.hansung.foodstagram.service;

import kr.ac.hansung.foodstagram.dao.ArticleRepository;
import kr.ac.hansung.foodstagram.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));

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

    public Article findById(Long id) {
        return articleRepository.findById(id).get();
    }

    public List<Article> findByDateAndUsername(String strDate, String username) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);

        return articleRepository.findByDateAndUsername(date, username);
    }

    public double getCalorieSumByDate(String username, String strDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strDate);
        List<Article> articles = articleRepository.findByDateAndUsername(date, username);

        double sum = 0;

        for (int i = 0; i < articles.size(); i++) {
            sum += articles.get(i).getCalorie();
        }

        return sum;
    }

    public double getUserAvg(String username) {
        List<Article> articles = articleRepository.findByUsername(username);
        double avg = 0;
        int i;

        for (i = 0; i < articles.size(); i++) {
            avg += articles.get(i).getCalorie();
        }
        avg = avg / i;
        return avg;
    }

    public double getUserSum(String username) {
        List<Article> articles = articleRepository.findByUsername(username);
        double sum = 0;

        for (int i = 0; i < articles.size(); i++) {
            sum += articles.get(i).getCalorie();
        }

        return sum;
    }


}
