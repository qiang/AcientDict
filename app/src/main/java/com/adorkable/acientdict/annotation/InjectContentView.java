package com.adorkable.acientdict.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: liuqiang 
 * Date: 2016-08-15
 * Time: 16:16
 * Description: 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface InjectContentView {

    /**
     * 顶部局的id
     *
     * @return
     */
    int value() default -1;

}
