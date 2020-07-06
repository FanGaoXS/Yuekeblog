package cn.wqk.blog.service;

import cn.wqk.blog.mapper.CommentMapper;
import cn.wqk.blog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> selectCommentByAid(int aid) {
        return commentMapper.selectCommentByAid(aid);
    }

    @Override
    public boolean insertComment(int aid, Comment comment) throws DataAccessException {
        //获取服务器当前系统时间
        Timestamp time = new Timestamp(new Date().getTime());
        comment.setTime(time);
        try {
            int i = commentMapper.insertComment1(comment);
            int i1 = commentMapper.insertComment2(aid, comment.getCid());
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }
}
