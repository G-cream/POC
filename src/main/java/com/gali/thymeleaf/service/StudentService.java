package com.gali.thymeleaf.service;

import com.gali.thymeleaf.entity.Student;
import com.gali.thymeleaf.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;

    public List<Map> findAll(){
        return  studentMapper.findAll();
    }

    public List<Map>findAll2(Integer id){

        return  studentMapper.findAll2(id);
    }


    public void delById(Integer user_id){

        studentMapper.delById(user_id);
    }

    public void create(Student student){
        studentMapper.create(student);
    }

    public void update(Student student){

        studentMapper.update(student);

    }


    public Student findById(int id){
       return studentMapper.findById(id);
    }
}
