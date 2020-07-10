package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    /**
     * 根据文章号查询该文章下的评论
     * @param aid（文章编号）
     * @return
     */
    List<Comment> selectCommentByAid(int aid);

    /**
     * 根据文章编号插入评论
     * @param aid 文章编号
     * @param commentStr 评论内容
     * @return 评论编号 返回-1代表错误
     */
    int insertComment(int aid,String commentStr);
}
