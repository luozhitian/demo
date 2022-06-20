package com.example.demo.mapper;

import com.example.demo.vo.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleMapper {

    public People queryByName(@Param("name") String name);

    public int insert(People people);

    public void deleteByName(@Param("name") String name);
}
