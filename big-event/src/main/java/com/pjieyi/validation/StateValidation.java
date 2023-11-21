package com.pjieyi.validation;

import com.pjieyi.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Author pjieyi
 * @Description 自定义校验注解的类
 * ConstraintValidator<给哪个注解提供校验规则,校验的数据类型>
 */
public class StateValidation implements ConstraintValidator<State,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则  返回false校验失败  返回true校验通过
        if (value==null){
            return false;
        }
        if (value.equals("已发布")|| value.equals("草稿")){
            return true;
        }
        return false;
    }
}
