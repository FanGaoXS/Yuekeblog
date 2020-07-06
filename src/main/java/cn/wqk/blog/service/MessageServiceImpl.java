package cn.wqk.blog.service;

import cn.wqk.blog.mapper.MessageMapper;
import cn.wqk.blog.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectAllMessage() {
        return messageMapper.selectAllMessage();
    }

    @Override
    public boolean insertMessage(Message message) {
        Timestamp time = new Timestamp(new Date().getTime());
        message.setTime(time);
        int i = messageMapper.insertMessage(message);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
