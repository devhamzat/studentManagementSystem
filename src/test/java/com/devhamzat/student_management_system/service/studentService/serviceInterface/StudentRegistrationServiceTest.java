package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentRegistrationServiceTest {
    @Mock
    private StudentRegistrationService underTest;

    @Test
    public void testRegisterStudent() {
        // given
        Student student = new Student();
        student.setEmail("chisDaniel@naija.com");

        when(underTest.registerStudent(student))
                .thenReturn(ResponseEntity.ok("Student successfully registered"));

        //when
        ResponseEntity<String> responseMessage = underTest.registerStudent(student);

        // then
        assertThat(responseMessage.getStatusCode());
        assertThat(responseMessage.getBody()).isEqualTo("Student successfully registered");
        verify(underTest, times(1)).registerStudent(student);
    }
}
