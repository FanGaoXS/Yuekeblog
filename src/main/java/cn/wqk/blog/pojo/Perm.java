package cn.wqk.blog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * perm
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Perm {
    /**
     * 权限编号
     */
    private Integer pid;

    /**
     * 权限名
     */
    private String pname;

    /**
     * 权限描述
     */
    private String pdetail;

    /**
     * 能访问的页面
     */
    private String url;
}