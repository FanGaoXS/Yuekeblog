package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    //根据文章编号查询该文章下的评论
    List<Comment> selectCommentByAid(@Param("aid")int aid);
    //新增评论，true新增成功，false新增失败
    boolean insertComment(int aid,Comment comment);
}
