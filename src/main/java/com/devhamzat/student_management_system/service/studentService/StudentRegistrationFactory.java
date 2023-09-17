package com.devhamzat.student_management_system.service.studentService;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationFactory {
    @Autowired
    private List<StudentRegistrationService> studentRegistrationServices;

    public void registerStudent(Student students) {
        for (StudentRegistrationService registrationService : studentRegistrationServices) {
            if (registrationService.getType() == students.getStudentType()) {
                registrationService.register(students);
            }
        }
    }

}
