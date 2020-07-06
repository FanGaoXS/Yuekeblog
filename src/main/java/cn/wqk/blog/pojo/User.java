package cn.wqk.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * user
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {
    /**
     * 用户编号
     */
    private Integer uid;

    /**
     * 登录的用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户的昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;
    private Perm perm;
}