package cn.wqk.blog.service;

import cn.wqk.blog.mapper.UserMapper;
import cn.wqk.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public boolean userRegister(User user) throws DataAccessException {
        try {
            int i = userMapper.insertUser1(user);
            int i1 = userMapper.insertUser2(user.getUid());
            return true;
        }catch (DataAccessException e){
            System.out.println(e);
            return false;
        }
    }
}
