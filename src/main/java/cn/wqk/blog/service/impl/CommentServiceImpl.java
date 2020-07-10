package cn.wqk.blog.service.impl;

import cn.wqk.blog.mapper.CommentMapper;
import cn.wqk.blog.pojo.Comment;
import cn.wqk.blog.service.CommentService;
import cn.wqk.blog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> selectCommentByAid(int aid) {
        return commentMapper.selectCommentByAid(aid);
    }
    @Override
    public int insertComment(int aid, String commentStr) throws DataAccessException{
        try {
            Comment comment = new Comment();
            comment.setComment(commentStr);
            comment.setTime(DateUtils.nowDateTime());
            commentMapper.insertComment1(comment);
            commentMapper.insertComment2(aid,comment.getCid());
            return comment.getCid();
        }catch (DataAccessException e){
            //@Transactional事物捕获异常，如果try发生异常，则回滚事务。
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return -1;
        }
    }
}
