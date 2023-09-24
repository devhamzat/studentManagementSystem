package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class StudentRegistrationServiceTest {
    private AutoCloseable autoCloseable;

    @Mock
    private StudentRegistrationService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

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
//
//    @Test
//    public void testGetTypeForDli() {
//        //given
//        when(underTest.getType())
//                .thenReturn(StudentType.DLI);
//        //when
//        StudentType type = underTest.getType();
//
//        //then
//        assertThat(type).isEqualTo(StudentType.DLI);
//        verify(underTest, times(1)).getType();
//    }
//
//    @Test
//    public void testGetTypeForUndergraduate() {
//        //given
//        when(underTest.getType())
//                .thenReturn(StudentType.UNDER_GRADUATE);
//        //when
//        StudentType type = underTest.getType();
//
//        //then
//        assertThat(type).isEqualTo(StudentType.UNDER_GRADUATE);
//        verify(underTest, times(1)).getType();
//    }
//
//    @Test
//    public void testGetTypeForPostGraduate() {
//        //given
//        when(underTest.getType())
//                .thenReturn(StudentType.POST_GRADUATE);
//        //when
//        StudentType type = underTest.getType();
//
//        //then
//        assertThat(type).isEqualTo(StudentType.POST_GRADUATE);
//        verify(underTest, times(1)).getType();
//    }
//
//    @Test
//    public void testGetTypeForFoundational() {
//        //given
//        when(underTest.getType())
//                .thenReturn(StudentType.FOUNDATIONAL);
//        //when
//        StudentType type = underTest.getType();
//
//        //then
//        assertThat(type).isEqualTo(StudentType.FOUNDATIONAL);
//        verify(underTest, times(1)).getType();
//    }
}
