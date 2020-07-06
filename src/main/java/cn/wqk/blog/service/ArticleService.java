package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleService {
    //查询所有文章
    List<Article> selectAllArticle();
    //根据文章id查询文章及其评论
    Article selectArticleByAid(int aid);
    //根据文章名模糊查询文章
    List<Article> selectArticleLikeTitle(String title);
    //新增文章，true新增成功，false新增失败
    boolean insertArticle(Article article);
}
