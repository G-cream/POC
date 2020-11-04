package com.gali.thymeleaf.controller;

import com.gali.thymeleaf.entity.Student;
import com.gali.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class StudentHtmlController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/index" , method = RequestMethod.GET)
    public String getHtml(Model model){

        model.addAttribute("students" ,studentService.findAll());

        return "index";

    }

    @RequestMapping(path = "/search" , method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam("id") Integer id){
        ModelAndView av=new ModelAndView("index");
        av.addObject("students",studentService.findAll2(id));
        av.addObject("keyValue",id);
        return av;

    }



    @RequestMapping(path = "/del")
    public String del(@RequestParam(name = "user_id") Integer user_id){
        studentService.delById(user_id);
        return "redirect:/index";

    }

    @RequestMapping(path = "/save" ,method = RequestMethod.POST)
    public String save(@ModelAttribute Student student){

        if(student==null){
            return "fail";
        }

        if(student.id!=null && student.id > 0){
            studentService.update(student);

            return "redirect:/index";

        }else{
            studentService.create(student);

            return "redirect:/index";
        }


    }


    @RequestMapping(path = "/findById" ,method = RequestMethod.GET)
    public Student findById(@RequestParam("id") Integer id){
      return   studentService.findById(id);

    }

    @RequestMapping(path = "/edit" , method = RequestMethod.GET)
    public String edit(ModelMap modelMap ,@RequestParam(defaultValue = "0") int id){
        if(id>0){
            modelMap.addAttribute("student",studentService.findById(id));
        }else{

            Student student=new Student();
            student.setAge(null);
            student.setName("");
            modelMap.addAttribute("student",student);
        }

        return "update";
    }





}
