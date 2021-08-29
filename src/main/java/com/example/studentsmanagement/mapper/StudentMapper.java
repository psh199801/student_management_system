package com.example.studentsmanagement.mapper;

import com.example.studentsmanagement.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student where name LIKE #{name}")
    List<Student> getStudentContainStrInName(@Param("name") String name);

    @Select("SELECT * FROM student where university_class_id IN " +
            "(SELECT id FROM university_class where year = #{year} AND number = #{number})")
    List<Student> getStudentsInClass(@Param("year") int year, @Param("number") int number);
}
