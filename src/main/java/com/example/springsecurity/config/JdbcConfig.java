package com.example.springsecurity.config;

import com.example.springsecurity.service.impl.UserDetailsServeiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;


/**
 * @ClassName JdbcConfig
 * @Description //TODO
 * @Date 2021/8/2711:11
 * @Version 1.0
 **/

@Configuration
public class JdbcConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        manager.createUser(User.withUsername("qifa")
//                .password(passwordEncoder().encode("aaa"))
//                .roles("admin").build());
//        return manager;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        JdbcUserDetailsManager userDetailsService = auth.jdbcAuthentication().dataSource(dataSource).getUserDetailsService();
//        userDetailsService.createUser(User.withUsername("zhuxu")
//                .password(passwordEncoder().encode("123"))
//                .roles("admin").build());
//
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.userDetailsService(new UserDetailsServeiceImpl())
//        .and()
//        .authenticationProvider();
//    }
        @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        JdbcUserDetailsManager userDetailsService = auth.jdbcAuthentication().dataSource(dataSource)
                .getUserDetailsService();


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
//                设置客户端最大登陆数
                .sessionManagement().maximumSessions(1)
//                用户一旦登录，就不允许在其他地方登录
                .maxSessionsPreventsLogin(true)
                .and().and().csrf().disable();
    }


    /**
     * 完成过期session的及时清理
     * */
    @Bean
    protected HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
}
