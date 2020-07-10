package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ArticleMapper {

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
     * @param aid 文章编号
     * @return Article 具体文章
     */
    Article selectArticleByAid(@Param("aid")int aid);

    /**
     * 根据文章标题模糊查询文章
     * @param title
     * @return
     */
    List<Article> selectArticleLikeTitle(@Param("title") String title);

    /**
     * 新增文章
     * @param article
     * @return
     */
    int insertArticle(Article article);
}
