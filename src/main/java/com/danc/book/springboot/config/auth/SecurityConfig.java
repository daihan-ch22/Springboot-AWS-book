package com.danc.book.springboot.config.auth;

import com.danc.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                    .permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint() //OAuth2 로그인 성공 후 사용자 정보 가져올 때의 설정 담당
                            .userService(customOAuth2UserService);
                            //소셜 로그인 성공시 후속 조치 시행할 UserService 인터페이스의 구현체를 등록
                            //리소스 서버(소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로
                            //진행하고자 하는 기능을 명시할 수 있다.

    }
}
