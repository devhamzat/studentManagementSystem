package com.devhamzat.student_management_system.utils.idGenerator;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component

public class PostGraduateStudentIDGenerator extends StudentIdGenerator {


    public PostGraduateStudentIDGenerator(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    public String generatePostgraduateID(boolean isUndergraduate) {
        String PREFIX;
        if (isUndergraduate) PREFIX = "UN";
        else PREFIX = "PS";
        return generateStudentId(PREFIX);
    }
}
