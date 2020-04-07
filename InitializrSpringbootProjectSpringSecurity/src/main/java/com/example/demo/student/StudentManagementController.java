/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.student;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alvaro
 */
@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Ana Smith")
    );
    
    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping
    public void registetNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }
    
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentid){
        System.out.println(studentid);
    }
    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
        System.out.println(String.format("%s %s", studentId,student));
    }
}
