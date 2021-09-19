package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersDao {
    int deleteByPrimaryKey(String username);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}