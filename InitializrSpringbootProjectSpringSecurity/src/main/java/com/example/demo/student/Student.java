/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.student;

/**
 *
 * @author Alvaro
 */
class Student {
    
    private final Integer studentId;
    private final String studentname;

    public Student(Integer studentId, String studentname) {
        this.studentId = studentId;
        this.studentname = studentname;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentname() {
        return studentname;
    }
    
    
    
}
