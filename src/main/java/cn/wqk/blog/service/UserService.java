package cn.wqk.blog.service;

import cn.wqk.blog.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return 存在返回User对象，不存在则返回null
     */
    User selectUserByUsername(String username);

    /**
     * 新用户注册
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return 成功返回用户编号，否则返回-1
     */
    int userRegister(String username,
                     String password,
                     String nickname);
}
