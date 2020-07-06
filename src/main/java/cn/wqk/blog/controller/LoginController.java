package cn.wqk.blog.controller;

import cn.wqk.blog.pojo.User;
import cn.wqk.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    //用户登录
    @RequestMapping("/login")
    public String login(User user,Model model){
        //获取当前登录用户
        Subject subject= SecurityUtils.getSubject();
        //封装用户登录的数据，以便校验
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {//成功
            subject.login(token);//subject对象匹配token里的登录密码
            return "redirect:/index";//登录成功返回index
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "front/login";//登录失败返回登录页面
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "redirect:/toLogin";
        }
    }
    //用户注销
    @RequestMapping("/logout")
    public String logout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }
}
