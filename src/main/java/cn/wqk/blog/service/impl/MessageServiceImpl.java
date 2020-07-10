package cn.wqk.blog.service.impl;

import cn.wqk.blog.mapper.MessageMapper;
import cn.wqk.blog.pojo.Message;
import cn.wqk.blog.service.MessageService;
import cn.wqk.blog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectAllMessage() {
        return messageMapper.selectAllMessage();
    }

    @Override
    public List<Message> selectAllMessageOrderByDesc() {
        return messageMapper.selectAllMessageOrderByDesc();
    }

    @Override
    public int insertMessage(String messageStr) throws DataAccessException {
        try{
            Message message = new Message();
            message.setMessage(messageStr);
            message.setTime(DateUtils.nowDateTime());
            messageMapper.insertMessage(message);
            return message.getMid();
        }catch (DataAccessException e){
            //@Transactional事物捕获异常，如果try发生异常，则回滚事物。
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return -1;
        }
    }

}
