package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    //查询所有留言
    List<Message> selectAllMessage();
    //新增留言，true留言成功，false留言失败
    boolean insertMessage(Message message);
}
