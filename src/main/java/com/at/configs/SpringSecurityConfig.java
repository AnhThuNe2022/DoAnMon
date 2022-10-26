/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.at.configs;

import com.at.handlers.LoginSuccessHandler;
import com.at.handlers.LogoutSuccessHandler;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author NguyenThiNgocNhi
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.at.controllers",
    "com.at.repository",
    "com.at.service",
    "com.at.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler successHandler;
    @Autowired
    private LogoutSuccessHandler logoutHandler;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("sdt").passwordParameter("pass");
        http.formLogin().successHandler(successHandler);
        http.logout().logoutSuccessHandler(logoutHandler);
        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");



        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_AD')")
                .antMatchers("/taixe/**")
                .access("hasRole('ROLE_TX')")
                 .antMatchers("/timve/chitiet/**")
                .access("hasAnyRole('ROLE_KH','ROLE_NV')")
                .antMatchers("/veCuaToi/**")
                .access("hasRole('ROLE_KH')");


        http.csrf().disable();
    }
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dck34xww3",
                "api_key", "335644493998576",
                "api_secret", "Xstc9w_2Pu2S-jdI8vyOPBiZhis",
                "secure", true
            ));
    return c;
    }

}
