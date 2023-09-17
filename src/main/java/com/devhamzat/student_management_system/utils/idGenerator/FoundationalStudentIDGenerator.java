package com.devhamzat.student_management_system.utils.idGenerator;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class FoundationalStudentIDGenerator extends StudentIdGenerator {
    private static final String PREFIX = "F";

    public FoundationalStudentIDGenerator(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    public String generateFoundationalStudentId() {
        return generateStudentId(PREFIX);
    }
}
