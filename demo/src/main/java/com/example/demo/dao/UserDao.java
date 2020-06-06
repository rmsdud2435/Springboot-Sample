package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {
    public List<UserDto> listPerson();

    public UserDto findById(String userId);

    public void addPerson(UserDto userDto) throws Exception;

    public void updatePerson(UserDto userDto);

    void deletePerson(String userId);

}
