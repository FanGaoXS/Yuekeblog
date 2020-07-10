package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    /**
     * 顺序查询所有留言
     * @return
     */
    List<Message> selectAllMessage();

    /**
     * 根据时间倒序查询所有留言
     * @return
     */
    List<Message> selectAllMessageOrderByDesc();

    /**
     * 新增留言
     * @param messageStr 留言内容
     * @return 返回留言编号，失败返回-1
     */
    int insertMessage(String messageStr);
}
