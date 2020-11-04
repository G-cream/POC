package com.gali.thymeleaf.controller;

import com.gali.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/get" , method = RequestMethod.GET)
    public List<Map> findAll(){

        return  studentService.findAll();

    }

}
