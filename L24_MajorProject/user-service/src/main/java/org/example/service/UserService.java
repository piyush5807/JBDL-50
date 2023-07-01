package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.User;
import org.example.repository.UserCacheRepository;
import org.example.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String USER_CREATE_TOPIC = "user_created";

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCacheRepository userCacheRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void create(User user) throws JsonProcessingException {
        userRepository.save(user);

        JSONObject userObj = new JSONObject();
        userObj.put("phone", user.getPhone());
        userObj.put("userId", user.getId());
        userObj.put("email", user.getEmail());

        kafkaTemplate.send(USER_CREATE_TOPIC,
                this.objectMapper.writeValueAsString(userObj));
    }

    public User get(int userId) throws Exception {
        User user = userCacheRepository.get(userId);
        if(user != null){
            return user;
        }

        user = userRepository.findById(userId).orElseThrow(() -> new Exception());
        userCacheRepository.set(user);
        return user;
    }
}
