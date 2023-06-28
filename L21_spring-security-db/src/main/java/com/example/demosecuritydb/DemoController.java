package com.example.demosecuritydb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String greet(){
        return "Hello world!!";
    }

    @PostMapping("/signup")
    public void signup(){

        /**
         * user creation -- encode the password and then save
         * authority
         */

    }

    // doc
    @GetMapping("/doctor/details")
    public String doctorAPI(){
        return "Hello doctor";
    }

    // deo
    @GetMapping("/deo/details")
    public String deoAPI(){
        return "Hello data entry operator";
    }

    // ceo
    @GetMapping("/ceo/details")
    public String ceoAPI(){
        return "Hello ceo";
    }

    // either doc or deo
    @GetMapping("/schedule/appointments")
    public String scheduleAppointment(){
        return "Hi!! your appointment is scheduled!!";
    }



}

