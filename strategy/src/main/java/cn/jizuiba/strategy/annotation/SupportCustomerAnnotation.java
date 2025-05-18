package cn.jizuiba.strategy.annotation;

import cn.jizuiba.strategy.constant.CustomerEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportCustomerAnnotation {

    CustomerEnum type();
}
