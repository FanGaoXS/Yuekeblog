package cn.wqk.blog.mapper;

import cn.wqk.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据用户名查询用户是否存在（Shiro）
     * @param username
     * @return 存在返回User对象，否则返回null
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * 新增用户表里的用户信息
     * @param user
     * @return
     */
    int insertUser1(User user);

    /**
     * 给新用户新增权限
     * @param uid 用户id
     * @param pid 权限id
     * @return
     */
    int insertUser2(int uid,int pid);
}
