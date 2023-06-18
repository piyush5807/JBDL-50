package com.example.demoredis.repository;

import com.example.demoredis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class PersonRepository {

    @Autowired
    RedisTemplate<String, Person> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final Integer PERSON_VALUE_EXPIRY = 1;
    private static final String PERSON_KEY_PREFIX = "person::";

    private static final String PERSON_LIST_KEY = "person_list";

    private static final String PERSON_HASH_KEY_PREFIX = "person_hash::";

    public void set(Person person){
        this.redisTemplate.opsForValue().set(getKey(person.getId()), person, PERSON_VALUE_EXPIRY, TimeUnit.DAYS);
    }

    public Set<String> getAllKeys(){
        return this.redisTemplate.keys(PERSON_KEY_PREFIX + "*");
    }

    public Person getById(String personId){
        return this.redisTemplate.opsForValue().get(getKey(personId));
    }

    public Person getByKey(String key){
        return this.redisTemplate.opsForValue().get(key);
    }

    private String getKey(String personId){
        return PERSON_KEY_PREFIX + personId;
    }

    // --------------------- List ops ----------------------------
    public void lpush(Person person) {
        redisTemplate.opsForList().leftPush(PERSON_LIST_KEY, person);
    }

    public void rpush(Person person) {
        redisTemplate.opsForList().rightPush(PERSON_LIST_KEY, person);
    }

    public List<Person> lpop(int counter) {
        return redisTemplate.opsForList().leftPop(PERSON_LIST_KEY, counter);
    }

    public List<Person> rpop(int counter) {
        return redisTemplate.opsForList().rightPop(PERSON_LIST_KEY, counter);
    }

    public List<Person> lrange(int start, int end){
        return this.redisTemplate.opsForList().range(PERSON_LIST_KEY, start, end);
    }

    // Hash Ops

    public void hmset(Person person){

        Map map = objectMapper.convertValue(person, Map.class);
        this.redisTemplate.opsForHash().putAll(getKeyForHash(person.getId()), map);
    }

    public Person hgetAll(String personId){
        Map map = this.redisTemplate.opsForHash().entries(getKeyForHash(personId));
        return objectMapper.convertValue(map, Person.class);
    }

    private String getKeyForHash(String personId){
        return PERSON_HASH_KEY_PREFIX + personId;
    }

}
