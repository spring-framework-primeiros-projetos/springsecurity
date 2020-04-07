/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security;

/**
 *
 * @author Alvaro
 */
public enum ApplicationUserPermission {
    STUDENT_READ("stuedent:read"),
    STUDENT_WRITE("stuedent:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");
    
    private final String permission;

    private ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
    
    public String getPermission(){
        return permission;
    }
}
