package cn.wqk.blog.controller;


import cn.wqk.blog.pojo.Comment;
import cn.wqk.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    //发表评论
    @RequestMapping("/newComment")
    public String newComment(@RequestParam("aid")int aid, Comment comment){
        boolean b = commentService.insertComment(aid, comment);
        if (b){//如果新增评论成功，重定向到该文章的详情页面
            return "redirect:/toDetail"+"?aid="+aid;
        }else {//如果新增评论失败，则重定向到评论页面
            return "redirect:/toComment";
        }
    }
}
