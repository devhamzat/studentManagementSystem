package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.utils.Gender;
import com.devhamzat.student_management_system.utils.StudentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    public void testFindStudentsByEmail() {
        //given
        Student student = new Student(

                "chrisdanil@gmai.com",
                "chris",
                "daniel",
                "20,week,we",
                Gender.male,
                StudentType.DLI,
                LocalDate.of(1999, 12, 31));
        underTest.save(student);
        //when
        Optional<Student> expectedStudent = underTest.findStudentsByEmail(student.getEmail());
        //then
        assertThat(expectedStudent).isPresent();
        assertThat(expectedStudent.get().getEmail()).isEqualTo(student.getEmail());
    }

}
