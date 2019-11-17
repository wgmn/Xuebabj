package com.gm.wj.controller;

import com.gm.wj.dao.ArticleDAO;
import com.gm.wj.pojo.Article;
import com.gm.wj.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/api/articles")
    public List<Article> list() throws Exception {
        return articleService.list();
    }
    @PostMapping("/api/articles")
    public Article addOrUpdate(@RequestBody Article article) throws Exception {
        System.out.println(article.getTitle());
        articleService.addOrUpdate(article);
        return article;
    }

}
