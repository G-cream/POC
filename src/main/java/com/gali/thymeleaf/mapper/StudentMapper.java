package com.gali.thymeleaf.mapper;

import com.gali.thymeleaf.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    public List<Map> findAll();

    public List<Map> findAll2(Integer id);

    public void delById(int user_id);

    public void create(Student student);

    public void  update(Student student);

    public Student findById(Integer id);

}
