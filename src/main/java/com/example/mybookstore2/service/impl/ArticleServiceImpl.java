package com.example.mybookstore2.service.impl;


import com.example.mybookstore2.entity.Article;
import com.example.mybookstore2.mapper.ArticleMapper;
import com.example.mybookstore2.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryArticles() {
        return articleMapper.queryArticles();
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public int deleteArticleById(int id) {
        return articleMapper.deleteArticleById(id);
    }
}
