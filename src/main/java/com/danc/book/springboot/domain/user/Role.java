package com.danc.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),  //Spring Security에서는 권한코드에 항상 ROLE_ 을 붙여야함

    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
