package com.pjieyi.anno;

import com.pjieyi.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @Author pjieyi
 * @Description 自定义校验参数
 */
@Documented //元注解 标识当前类可以抽取到帮助文档中
@Target({ElementType.FIELD}) //元注解 标识可以用到哪些地方 FIELD属性上面
@Retention(RetentionPolicy.RUNTIME) //元注解 哪个阶段会被保留 RUNTIME运行时阶段
@Constraint(validatedBy = StateValidation.class) //谁给当前注解提供校验的规则
public @interface State {

    //校验失败后的提示信息
    String message() default "文章状态只能是：已发布或草稿";
    //指定分组
    Class<?>[] groups() default {};

    //负载 获取到state注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
