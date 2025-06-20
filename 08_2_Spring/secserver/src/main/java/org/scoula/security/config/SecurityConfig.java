package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity  // Spring Security 활성화
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter= new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");

        http.formLogin() // 로그인 설정 시작
                .loginPage("/security/login") // 로그인 페이지 GET URL  sercurity/login 뷰(jsp) 정의
                .loginProcessingUrl("/security/login") // 로그인 POST URL  login form의 action에 지정
                .defaultSuccessUrl("/"); // 로그인 성공 시 이동(redirect)할 페이지

        http.logout() // 로그아웃 설정 시작
                .logoutUrl("/security/logout") // POST: 로그아웃 호출 url -> post요청으로만 로그아웃이 가능
                .invalidateHttpSession(true) // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure .........................................");
//
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}1234")
//                .password("$2a$10$D9kGByxfyJ.t6UhTlQijKub1w9vHbdo94YhZ0SiquX1JYc7.pfgKG")
//                .roles("ADMIN","MEMBER"); // ROLE_ADMIN
//
//        auth.inMemoryAuthentication()
//                .withUser("member")
//                .password("{noop}1234")
//                .password("$2a$10$f4w4eHUfQ8fGnq3TndxWq.g.9wl9iPf5.76gh30n5MEkNs/nDbvri")
//                .roles("MEMBER"); // ROLE_MEMBER
//        in memory user 정보 삭제 -> UserDetailsService와 혼용 불가능
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
