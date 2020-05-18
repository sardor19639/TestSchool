package com.online.school.services;

import com.online.school.controller.IndexController;
import com.online.school.model.Student;
import com.online.school.repositories.StudentMyBatisRepository;
//import com.online.school.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StudentMyBatisRepository studentMyBatisRepository;

    public void saveStudent(Student student){
        log.info("name " + student.getName() + " surname:" + student.getSurname());
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setSurname(student.getSurname());
        newStudent.setActive(true);
        studentMyBatisRepository.insert(newStudent);

    }

    public void deleteStudent(Integer id){
        studentMyBatisRepository.delete(id);
//        student.setActive(false);
//        studentRepository.save();

    }

    public List<Student> getAllStudents() {
        return studentMyBatisRepository.students();
    }

}
