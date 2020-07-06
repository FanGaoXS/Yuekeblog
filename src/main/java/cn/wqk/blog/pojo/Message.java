package cn.wqk.blog.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * message
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Message {
    /**
     * 留言编号
     */
    private Integer mid;

    /**
     * 留言内容
     */
    private String message;

    /**
     * 留言者名字
     */
    private String name;

    /**
     * 留言时间
     */
    private Date time;

}