package com.example.minor1.controllers;

import com.example.minor1.dtos.CreateStudentRequest;
import com.example.minor1.models.SecuredUser;
import com.example.minor1.models.Student;
import com.example.minor1.services.StudentService;
import com.example.minor1.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // Unsecured
    @PostMapping("/student/create") // kind of a sign-up API
    public void createStudent(@RequestBody @Valid CreateStudentRequest studentRequest){
        studentService.create(studentRequest.to());
    }

    // Secured
    // Only for admins so that they can any student's details
    @GetMapping("/student-by-id/{id}")
    public Student findStudentById(@PathVariable("id") int studentId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();

        for(GrantedAuthority grantedAuthority: securedUser.getAuthorities()){
            String[] authorities = grantedAuthority.getAuthority().split(Constants.DELIMITER);
            boolean isCalledByAdmin = Arrays.stream(authorities).anyMatch(x -> Constants.STUDENT_INFO_AUTHORITY.equals(x));
            if (isCalledByAdmin) {
                return studentService.find(studentId);
            }

        }

        throw new Exception("User is not authorized to do this");

    }


    // Only for student so that can they see their details
    @GetMapping("/student")
    public Student findStudent(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        int studentId = user.getStudent().getId();

        return studentService.find(studentId);
    }

    // select * from user where id = ?

    // select * from student where user_id = ?
    // select * from admin where user_id = ?



}
