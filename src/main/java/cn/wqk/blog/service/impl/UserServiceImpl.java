package cn.wqk.blog.service.impl;

import cn.wqk.blog.mapper.UserMapper;
import cn.wqk.blog.pojo.User;
import cn.wqk.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public int userRegister(String username,
                            String password,
                            String nickname) throws DataAccessException{
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            userMapper.insertUser1(user);
            userMapper.insertUser2(user.getUid(),2);
            return user.getUid();
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return -1;
        }
    }


}
