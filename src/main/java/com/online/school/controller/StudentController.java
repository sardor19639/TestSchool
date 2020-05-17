package com.online.school.controller;

import com.online.school.model.AjaxResponseBody;
import com.online.school.model.Student;
import com.online.school.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/api/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }
        List<Student> users = studentService.getAllStudents();
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        studentService.saveStudent(student);
        result.setResult(users);

        return ResponseEntity.ok(result);

    }


    @PostMapping("/api/delete")
    public ResponseEntity<?> deleteStudent(@Valid @RequestBody Student student, Errors errors) {
        log.info("id " + student.getId());

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }
        List<Student> users = studentService.getAllStudents();
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        studentService.deleteStudent(student.getId().intValue());
        result.setResult(users);
        return ResponseEntity.ok(result);

    }


}
