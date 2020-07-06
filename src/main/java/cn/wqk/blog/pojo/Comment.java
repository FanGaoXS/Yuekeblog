package cn.wqk.blog.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * comment
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Comment {
    /**
     * 评论编号
     */
    private Integer cid;

    /**
     * 评论者
     */
    private String cname;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论时间
     */
    private Date time;
}