package com.devhamzat.student_management_system.utils.idGenerator;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component

public class PostGraduateStudentIDGenerator extends StudentIdGenerator {

    private static final String PREFIX = "PG";
    public PostGraduateStudentIDGenerator(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    public String generatePostgraduateID() {

        return generateStudentId(PREFIX);
    }
}
