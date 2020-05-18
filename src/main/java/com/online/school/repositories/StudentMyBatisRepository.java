package com.online.school.repositories;


import com.online.school.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Sardor Rokhillayev
 * @since 2020-05-18
 */
@Repository
@Mapper
public interface StudentMyBatisRepository {

    @Insert("INSERT INTO students(active, name, surname) " +
            " VALUES (#{active}, #{name}, #{surname})")
    int insert(Student student);

    @Select("SELECT * FROM students WHERE active = true")
    List<Student> students();

    @Update("Update students set active=false " +
            "where id=#{id}")
    int delete(Integer id);

}
