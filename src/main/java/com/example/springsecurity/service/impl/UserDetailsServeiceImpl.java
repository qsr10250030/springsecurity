package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.Users;
import com.example.springsecurity.mapper.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName UserDetailsServeiceImpl
 * @Description //TODO
 * @Date 2021/8/2715:12
 * @Version 1.0
 **/
@Service
public class UserDetailsServeiceImpl implements UserDetailsService {

    @Autowired
    UsersDao usersDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("sss="+s);
        Users user = usersDao.selectByPrimaryKey(s);
        if(user!=null){
            System.out.println("s="+s+"name="+user.getUsername());
            return  new User(user.getUsername(), user.getPassword(),user.getEnabled(),true,
                    true,true,
                    Collections.singletonList(new SimpleGrantedAuthority("ddd")));
        }else {
            throw new BadCredentialsException("我错了");
        }

    }
}
