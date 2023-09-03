package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Courses;
import com.devhamzat.student_management_system.entity.Registration;
import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.repository.CourseRepository;
import com.devhamzat.student_management_system.repository.RegistrationRepository;
import com.devhamzat.student_management_system.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationService {
    @Autowired
    public RegistrationRepository registrationRepository;
    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public CourseRepository courseRepository;

    public RegistrationService(RegistrationRepository registrationRepository,StudentRepository studentRepository,CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
    public void registerNewCourses(Long studentId, Long courseId){
        Students students = studentRepository.findStudentsById(studentId).orElseThrow(() ->new EntityNotFoundException("Student not found"));
        Courses courses = courseRepository.findCoursesById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found"));
        Registration registration = new Registration();
        registration.setCourses(courses);
        registration.setStudents(students);
        registration.setTimeRegistered(LocalDate.now());
        registrationRepository.save(registration);


    }
}
