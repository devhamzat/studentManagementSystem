package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Lecturers;
import com.devhamzat.student_management_system.repository.LecturersRepository;
import com.devhamzat.student_management_system.utils.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturersService {
    public LecturersRepository lecturersRepository;

    @Autowired
    public LecturersService(LecturersRepository lecturersRepository) {
        this.lecturersRepository = lecturersRepository;
    }


    public void addLecturers(Lecturers lecturers) {
        Optional<Lecturers> lecturersOptional = lecturersRepository.findLecturersByEmail(lecturers.getEmail());
        if (lecturersOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        } else if (lecturers.getRoleType() != RoleType.lecturer) {
            throw new IllegalStateException("role type not compatible");
        }

        lecturersRepository.save(lecturers);
    }

    public List<Lecturers> getLecturers() {
        return lecturersRepository.findAll();
    }

}
