package com.example.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String greet(){
        return "Hello world!!";
    }

    // doc
    @GetMapping("/doctor")
    public String doctorAPI(){
        return "Hello doctor";
    }

    // deo
    @GetMapping("/deo")
    public String deoAPI(){
        return "Hello data entry operator";
    }

    // ceo
    @GetMapping("/ceo")
    public String ceoAPI(){
        return "Hello ceo";
    }

    // either doc or deo
    @GetMapping("/schedule/appointments")
    public String scheduleAppointment(){
        return "Hi!! your appointment is scheduled!!";
    }



}
