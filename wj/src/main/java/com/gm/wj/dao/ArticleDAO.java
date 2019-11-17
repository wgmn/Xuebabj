package com.gm.wj.dao;

import com.gm.wj.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDAO extends JpaRepository<Article,Integer> {
    // List<Article> findAllByTitle(String title);
    //List<Article> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
    //List<Article> findAllBy(String keyword1);
}
