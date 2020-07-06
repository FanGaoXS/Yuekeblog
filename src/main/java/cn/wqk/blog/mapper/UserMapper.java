package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //根据用户名查询用户以及他的权限（登录用）
    User selectUserByUsername(String username);
    //新增用户1（用户注册），uid自增
    int insertUser1(User user);
    //新增用户2（中间表新增）
    int insertUser2(int uid);
}
