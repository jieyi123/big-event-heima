package com.pjieyi.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer id;//主键ID

    private String username;//用户名
    @JsonIgnore //让springMVC把当前对象转化成json字符串返回时，最终的结果就没有password这个字段
    private String password;//密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}") //不能为空串,并且内容满足要求
    private String nickname;//昵称

    @NotEmpty
    @Email  //符合邮件格式
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
