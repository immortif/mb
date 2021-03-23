package ecom.mbc.mappers;

import org.apache.ibatis.annotations.Param;

import ecom.mbc.pojo.Student;

public interface StudentMapper {
    void insertByStudentEntity(Student student);

    Student findStudentByColumn(@Param("column") String column, @Param("value") String value);

    Student findStudentById(int id);
}
