package com.william.studentapi.controllers;

import com.william.studentapi.model.Student;
import com.william.studentapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //localhost:8080/student
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public void createStudentRecord(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/allstudents", method = RequestMethod.GET)
    public List<Student> getAllStudentRecords(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/getstudent", method = RequestMethod.GET)
    public Optional<Student> getStudentById(@RequestBody Long id){
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/updatestudent/{id}", method = RequestMethod.PUT)
    public void updateStudentRecord(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "/deletestudent", method = RequestMethod.DELETE)
    public void deleteStudentRecord(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
