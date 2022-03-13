package me.syp.demospringdi;

import java.lang.annotation.*;

/**
 * [2] Annotation을 Runtime을 조회하기
 * (RetentionPolicy.RUNTIME): Runtime 시에도 Annotaiton을 유지한다.
 * 기본 값은 RetentionPolicy.CLASS이다.
 * [3] Annotation을 사용할 수 있는 위치 제한하기.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface AnotherAnnotation {
    // default: 기본값을 지정할 수 있다.
    // 설정하지 않으면 애노테이션 설정 시 매개변수 형식으로 지정해야한다.
    // ex) @MyAnnotation(name = "sungyong", number = 11)
    String name() default "sungyong";
    int number() default 11;

    // value로 지정하면 명시할 매개변수 형식으로 지정할 때에 변수명을 명시하지 않아도 된다.
    // => @MyAnnotation("sungyong")
    String value();
}
