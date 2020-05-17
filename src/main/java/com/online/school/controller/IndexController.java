package com.online.school.controller;

import com.online.school.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("students");

        mv.addObject("students", studentService.getAllStudents());
        return mv;
    }

    @GetMapping("/students")
    public ModelAndView students() {
        ModelAndView mv = new ModelAndView("students");

        mv.addObject("students", studentService.getAllStudents());
        return mv;
    }
}