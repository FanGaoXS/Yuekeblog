package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface ArticleService {

    /**
     * 顺序列出所有文章
     * @return
     */
    List<Article> selectAllArticle();

    /**
     * 根据时间倒序列出所有文章，时间离现在越近越靠上面
     * @return
     */
    List<Article> selectAllArticleOrderByDesc();

    /**
     * 根据文章编号查询具体文章
     * @param aid
     * @return
     */
    Article selectArticleByAid(int aid);

    /**
     * 根据文章名模糊查询文章
     * @param title
     * @return
     */
    List<Article> selectArticleLikeTitle(String title);

    /**
     * 新增文章
     * @param title 文章标题
     * @param content 文章内容
     * @return
     */
    int insertArticle(String title,String content);
}
