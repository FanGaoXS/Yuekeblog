package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    //查询所有留言
    List<Message> selectAllMessage();
    //新增留言
    int insertMessage(Message message);
}
