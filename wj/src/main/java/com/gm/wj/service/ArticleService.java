package com.gm.wj.service;

import com.gm.wj.dao.ArticleDAO;
import com.gm.wj.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService {
    @Autowired
    ArticleDAO articleDAO;
    public List<Article> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return articleDAO.findAll(sort);
    }
    public void addOrUpdate(Article article) {
        articleDAO.save(article);
    }

}
