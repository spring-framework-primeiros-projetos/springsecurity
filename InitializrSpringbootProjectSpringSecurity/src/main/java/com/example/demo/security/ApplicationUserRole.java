/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Alvaro
 */
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(
//            ApplicationUserPermission.COURSE_READ,
//            ApplicationUserPermission.STUDENT_READ,
//            ApplicationUserPermission.STUDENT_WRITE
    )),
    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE,
            ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE
    )),
    
    ADMINTRAINEE(Sets.newHashSet(
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.STUDENT_READ
    ));
    
    private final Set<ApplicationUserPermission> permissons;

    private ApplicationUserRole(Set<ApplicationUserPermission> permissons) {
        this.permissons = permissons;
    }
    
    private Set<ApplicationUserPermission> getPermissions() {
        return permissons;
        
    }
    
    public Set<SimpleGrantedAuthority> getGrantedAuthoritys(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permissons -> new SimpleGrantedAuthority(permissons.getPermission()))
                .collect(Collectors.toSet());
                
        
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    
}
