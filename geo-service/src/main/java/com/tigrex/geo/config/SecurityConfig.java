package com.tigrex.geo.config;

import com.tigrex.geo.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author linus
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 1\. HttpSecurity被声明为链式调用
         * 其中配置方法包括
         *  1\. authorizeRequests（）url拦截配置
         *  2\. formLogin（）表单验证
         *  3\. httpBasic（）表单验证
         *  4\. csrf（）提供的跨站请求伪造防护功能
         */
        /**
         * 2\. authorizeRequests目的是指定url进行拦截的，也就是默认这个url是“/”也就是所有的
         * anyanyRequest（）、antMatchers（）和regexMatchers（）三种方法来拼配系统的url。并指定安全策略
         */
        http.authorizeRequests()
                //这里指定什么样的接口地址的请求，需要什么样的权限 ANT模式的URL匹配器
                //用户可以有查询权限
                .antMatchers("/select/**").hasRole("USER")
                //管理员可以有插入权限权限
                .antMatchers("/insert/**").hasRole("ADMIN")
                //超级管理员才有赋权的权限
                .antMatchers("/empower/**").hasRole("SUPERADMIN")
                //标识list所有权限都可以直接访问，即使不登录也可以访问。一般将login页面放给这个权限
                .antMatchers("/user/login").permitAll()
                .and()
                .formLogin()
//                .loginProcessingUrl("/login/user")//用来定义什么样的API请求时login请求
//                .permitAll()//login请求需要是所有权限都可以的
                .and().csrf().disable();

        /**
         * 将自定义过滤器加入configure中
         */
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(this.authenticationManager());
        http.addFilterBefore(jwtAuthenticationFilter, JwtAuthenticationFilter.class);
    }
}
