package com.example.demoredis.service;

import com.example.demoredis.model.Person;
import com.example.demoredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void create(Person person){
        personRepository.set(person);
    }

    public Person get(String personId) {
        return personRepository.getById(personId);
    }

    public List<Person> get(){
        Set<String> keys = personRepository.getAllKeys();
        return keys.stream()
                .map(k -> personRepository.getByKey(k))
                .collect(Collectors.toList());
    }

   // ----------------------------- List Operations ------------------------------

    public void lpush(Person person){
        personRepository.lpush(person);
    }

    public void rpush(Person person){
        personRepository.rpush(person);
    }

    public List<Person> lpop(int count){
        return personRepository.lpop(count);
    }

    public List<Person> rpop(int count){
        return personRepository.rpop(count);
    }

    public List<Person> lrange(int start, int end){
        return personRepository.lrange(start, end);
    }

    // ---------------- Hash Ops ---------------

    public void setPersonInHash(Person person){
        personRepository.hmset(person);
    }

    public Person getPersonFromHash(String personId){
        return personRepository.hgetAll(personId);
    }
}
