package cn.wqk.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/07/08/20:38
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    public void insertArticle() {
        int article = articleService.insertArticle("test", "test");
        System.out.println(article);
    }
}