package cn.wqk.blog.service;

import cn.wqk.blog.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //根据用户名查询用户以及他的权限（登录用）
    User selectUserByUsername(String username);
    //用户注册（true注册成功）
    boolean userRegister(User user);
}
