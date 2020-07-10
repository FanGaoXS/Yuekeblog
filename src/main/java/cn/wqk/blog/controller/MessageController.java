package cn.wqk.blog.controller;


import cn.wqk.blog.pojo.Message;
import cn.wqk.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    //发表留言
    @RequestMapping("/newMessage")
    public String newMessage(Message message){
        int mid = messageService.insertMessage(message.getMessage());
        if (mid!=-1){//如果留言发表成功，则会重定向到所有留言页面
            return "redirect:/toMessage";
        }else {//如果留言失败
            return "redirect:/toMessage";
        }
    }

}
