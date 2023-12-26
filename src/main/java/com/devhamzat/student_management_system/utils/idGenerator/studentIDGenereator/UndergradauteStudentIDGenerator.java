package com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator;

import com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator.StudentIdGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component

public class UndergradauteStudentIDGenerator extends StudentIdGenerator {
    private static final String PREFIX = "UN";

    public UndergradauteStudentIDGenerator(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    public String generateUndergraduateStudentId() {
        return generateStudentId(PREFIX);
    }
}
