package cn.wqk.blog.controller;

import cn.wqk.blog.pojo.Article;
import cn.wqk.blog.pojo.Comment;
import cn.wqk.blog.pojo.Message;
import cn.wqk.blog.service.ArticleService;
import cn.wqk.blog.service.CommentService;
import cn.wqk.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RouterController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CommentService commentService;
    //去到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "front/login";
    }
    //去到关于页面
    @RequestMapping("/toAbout")
    public String toAbout(){
        return "front/about";
    }
    //去到发表文章的页面
    @RequestMapping("/toArticle")
    public String toArticle(){ return "front/article"; }
    //去到首页，并且展示所有文章
    @RequestMapping({"/toIndex","/index","/"})
    public String toIndex(Model model){
        List<Article> articleList = articleService.selectAllArticleOrderByDesc();
        model.addAttribute("articleList",articleList);
        return "front/index";
    }
    //去到某个文章的评论页面，这个页面显示该文章信息，不显示评论信息
    @RequestMapping("/toComment")
    public String toComment(@RequestParam("aid")int aid,Model model){
        Article article = articleService.selectArticleByAid(aid);
        model.addAttribute("article",article);
        return "front/comment";
    }
    //去到留言页面，这里会展示所有留言
    @RequestMapping("/toMessage")
    public String toMessage(Model model){
        List<Message> messageList = messageService.selectAllMessage();
        model.addAttribute("messageList",messageList);
        return "front/message";
    }
    //去到某文章的详情页面，该页面有该文章的信息以及该文章下面的所有评论
    @RequestMapping("/toDetail")
    public String toDetails(@RequestParam("aid")int aid,Model model){
        //根据文章aid查询到文章
        Article article = articleService.selectArticleByAid(aid);
        List<Comment> commentList = commentService.selectCommentByAid(aid);
        //以及该文章的所有评论
        model.addAttribute("article",article);
        model.addAttribute("commentList",commentList);
        return "front/detail";
    }
}
