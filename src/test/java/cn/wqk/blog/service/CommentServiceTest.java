package cn.wqk.blog.service;

import cn.wqk.blog.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/07/08/21:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    CommentService commentService;
    @Test
    void selectCommentByAid() {
        List<Comment> commentList = commentService.selectCommentByAid(3);
        for (Comment comment : commentList) {
            System.out.println(comment);
        }
    }

    @Test
    void insertComment() {
        int i = commentService.insertComment(3, "测试");
        System.out.println(i);
    }
}