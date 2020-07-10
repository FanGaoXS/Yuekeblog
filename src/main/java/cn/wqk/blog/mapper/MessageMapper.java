package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    /**
     * 顺序查询所有留言
     * @return
     */
    List<Message> selectAllMessage();

    /**
     * 根据时间倒序查询所有留言，时间离现在越近越靠上面
     * @return
     */
    List<Message> selectAllMessageOrderByDesc();

    /**
     * 新增留言
     * @param message
     * @return
     */
    int insertMessage(Message message);
}
