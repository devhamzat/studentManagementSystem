package com.devhamzat.student_management_system.utils.idGenerator;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentIdGenerator {

    private RedisTemplate<String, String> redisTemplate;

    public StudentIdGenerator(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generateStudentId(String prefix) {
        String key = "student_id_counter" + prefix;
        Long id = redisTemplate.opsForValue().increment(key);
        return prefix + LocalDate.now().getYear() + String.format("%04d", id);
    }
}
