package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ArticleMapper {
    //查询出所有文章
    List<Article> selectAllArticle();
    //根据文章编号查询文章及其评论
    Article selectArticleByAid(@Param("aid")int aid);
    //根据文章标题模糊查询相似文章
    List<Article> selectArticleLikeTitle(@Param(("title")) String title);
    //发表文章
    int insertArticle(Article article);
}
