package com.devhamzat.student_management_system.service.studentService.dli;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator.DLIStudentIDgenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DLIStudentRegistrationServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private DLIStudentIDgenerator dliStudentIDgenerator;
    @InjectMocks
    private DLIStudentRegistrationService underTest;


    @Test
    void testRegisterStudent() {
        // Given
        Student student = new Student();
        student.setEmail("chrisdaniel@gmail.com");
        student.setStudentType(StudentType.DLI);
        student.setStudentId("DLI20230001");

        when(dliStudentIDgenerator.generateDLIStudentId()).thenReturn(student.getStudentId());
        when(studentRepository.findStudentsByEmail("chrisdaniel@gmail.com")).thenReturn(Optional.empty());

        // When
        ResponseEntity<String> responseMessage = underTest.registerStudent(student);

        // Then
        assertThat(responseMessage.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseMessage.getBody()).isEqualTo("Student successfully registered into distance learning institute with id : " + student.getStudentId());
    }

    @Test
    void testGetType() {

        //when
        StudentType studentType = underTest.getType();

        //then
        assertThat(studentType).isEqualTo(StudentType.DLI);
    }
}