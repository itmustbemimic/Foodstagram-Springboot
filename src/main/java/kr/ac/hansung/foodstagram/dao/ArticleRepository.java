package kr.ac.hansung.foodstagram.dao;

import kr.ac.hansung.foodstagram.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    List<Article> findByUsername(String username);

    List<Article> findByTextContaining(String keyword);





}
