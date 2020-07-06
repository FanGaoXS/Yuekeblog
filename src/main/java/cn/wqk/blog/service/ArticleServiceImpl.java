package cn.wqk.blog.service;

import cn.wqk.blog.mapper.ArticleMapper;
import cn.wqk.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
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
    public boolean insertArticle(Article article) {
        Timestamp time = new Timestamp(new Date().getTime());
        article.setTime(time);
        int i = articleMapper.insertArticle(article);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
