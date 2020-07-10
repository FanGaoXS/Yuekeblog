package cn.wqk.blog.service.impl;

import cn.wqk.blog.mapper.ArticleMapper;
import cn.wqk.blog.pojo.Article;
import cn.wqk.blog.service.ArticleService;
import cn.wqk.blog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }

    @Override
    public List<Article> selectAllArticleOrderByDesc() {
        return articleMapper.selectAllArticleOrderByDesc();
    }

    @Override
    public Article selectArticleByAid(int aid) {
        return articleMapper.selectArticleByAid(aid);
    }

    @Override
    public List<Article> selectArticleLikeTitle(String title) {
        return articleMapper.selectArticleLikeTitle(title);
    }

    @Override
    public int insertArticle(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setTime(DateUtils.nowDateTime());
        articleMapper.insertArticle(article);
        return article.getAid();
    }
}
