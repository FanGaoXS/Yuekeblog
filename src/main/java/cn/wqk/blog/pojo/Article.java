package cn.wqk.blog.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * article
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Article{
    /**
     * 文章编号
     */
    private Integer aid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章存入时间
     */
    private Date time;

    /**
     * 文章图片路径
     */
    private String picture;
}