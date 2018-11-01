//package com.eastmoney.readinglist;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author Administrator
// * created: 2018-10-31 17:39
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final ReaderRepository readerRepository;
//
//    @Autowired
//    public SecurityConfig(ReaderRepository readerRepository) {
//        this.readerRepository = readerRepository;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/").access("hasRole('READER')") // 要求登录者有READER角色
//            .antMatchers("/**").permitAll()
//            .and()
//            .formLogin()
//                .loginPage("/login") // 设置登录表单的路径
//                .failureUrl("/login?error=true");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> readerRepository.findById(username).get());
//    }
//}
