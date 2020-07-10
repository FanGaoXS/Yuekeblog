package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentMapper {

    /**
     * 根据文章号查询该文章下的评论
     * @param aid 文章编号
     * @return
     */
    List<Comment> selectCommentByAid(@Param("aid")int aid);

    /**
     * 往评论表里新增评论
     * @param comment
     * @return
     */
    int insertComment1(Comment comment);

    /**
     * 向文章_评论中间表
     * @param aid
     * @param cid
     * @return
     */
    int insertComment2(@Param("aid")int aid,@Param("cid")int cid);
}
