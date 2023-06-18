package com.example.demoredis.controller;

import com.example.demoredis.dto.PersonCreateRequest;
import com.example.demoredis.model.Person;
import com.example.demoredis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    /**
     *      String operations
     */

    @Autowired
    PersonService personService;

    @PostMapping("/")
    public void createPerson(@RequestBody @Valid PersonCreateRequest request){
        personService.create(request.to());
    }

    @GetMapping("/")
    public Person getPerson(@RequestParam("id") String personId){
        return personService.get(personId);
    }

    @GetMapping("/all")
    public List<Person> getPeople(){
        return personService.get();
    }

    /**
     *      List operations
     */

    @PostMapping("/lpush")
    public void lpush(@RequestBody @Valid PersonCreateRequest request){
        personService.lpush(request.to());
    }

    @PostMapping("/rpush")
    public void rpush(@RequestBody @Valid PersonCreateRequest request){
        personService.rpush(request.to());
    }

    @DeleteMapping("/lpop")
    public List<Person> lpop(@RequestParam(value = "count", required = false, defaultValue = "1") int count){
        return personService.lpop(count);
    }

    @DeleteMapping("/rpop")
    public List<Person> rpop(@RequestParam(value = "count", required = false, defaultValue = "1") int count){
        return personService.rpop(count);
    }

    @GetMapping("/lrange")
    public List<Person> lrange(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                               @RequestParam(value = "end", required = false, defaultValue = "-1") int end){
        return personService.lrange(start, end);
    }


    /**
     *      Hash Operations
     */

    @PostMapping("/hash")
    public void createPersonInHash(@RequestBody @Valid PersonCreateRequest request){
       personService.setPersonInHash(request.to());
    }

    @GetMapping("/hash/{personId}")
    public Person getPersonFromHash(@PathVariable("personId") String personId){
        return personService.getPersonFromHash(personId);
    }


}
