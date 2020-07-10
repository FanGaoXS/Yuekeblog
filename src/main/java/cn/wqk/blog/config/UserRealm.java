package cn.wqk.blog.config;

import cn.wqk.blog.pojo.User;
import cn.wqk.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();//拿到user对象
        info.addStringPermission(currentUser.getPerm().getPname());//获取到该user对象的权限并赋给它
        return info;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取前端给予的Token对象里面封装了用户名和密码
        UsernamePasswordToken userToken=(UsernamePasswordToken)authenticationToken;
        //将token里的用户名用来查询数据库里是否存在该用户
        User user = userService.selectUserByUsername(userToken.getUsername());
        if (user==null){//如果用户不存在
            return null;//抛出异常UnknownAccountException
        }
        //获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        //获取当前的session
        Session session = subject.getSession();
        //向当前对象的session里存值
        session.setAttribute("loginUser",user);
        //返回密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
