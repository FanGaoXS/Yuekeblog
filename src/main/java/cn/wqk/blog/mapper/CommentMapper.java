package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentMapper {
    //根据文章编号查询该文章下的评论
    List<Comment> selectCommentByAid(@Param("aid")int aid);
    //增加评论1（增加评论表里的评论）
    int insertComment1(Comment comment);
    //增加评论2（增加中间表的aid）
    int insertComment2(@Param("aid")int aid,@Param("cid")int cid);
}
