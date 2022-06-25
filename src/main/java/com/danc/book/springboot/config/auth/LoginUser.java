package com.danc.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.PARAMETER)  //이 애너테이션이 생성될 수 있는 위치 지정 (메서드의 파라미터로 선언된 객체만)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // @interface 이 파일을 애너테이션 클래스로 지정 / LoginUser라는 애너테이션을 만들었다 보면 된다.
}
