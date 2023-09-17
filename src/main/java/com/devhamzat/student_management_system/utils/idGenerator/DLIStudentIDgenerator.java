package com.devhamzat.student_management_system.utils.idGenerator;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DLIStudentIDgenerator extends StudentIdGenerator {
    private static final String PREFIX = "DLI";

    public DLIStudentIDgenerator(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    public String generateDLIStudentId() {
        return generateStudentId(PREFIX);
    }
}
