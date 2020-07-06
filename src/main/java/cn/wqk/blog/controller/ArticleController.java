package cn.wqk.blog.controller;


import cn.wqk.blog.pojo.Article;
import cn.wqk.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //根据文章标题模糊系列文章
    @RequestMapping("/likeTitle")
    public String likeTitle(@RequestParam("title")String title, Model model){
        List<Article> articleList = articleService.selectArticleLikeTitle(title);
        model.addAttribute("articleList",articleList);
        return "front/index";
    }
    //新增文章
    @RequestMapping("/newArticle")
    public String newArticle(Article article){
        boolean b = articleService.insertArticle(article);
        if (b){//如果新增成功，重定向到该文章的详情页面，并且传递aid
            int aid=article.getAid();
            return "redirect:/toDetail"+"?aid="+aid;
        }else {//如果新增失败，则返回发表文章的页面
            return "redirect:toArticle";
        }
    }
}
