package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.entity.Lecturers;
import com.devhamzat.student_management_system.service.LecturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    @Autowired
    private LecturersService lecturersService;

    @PostMapping
    public void addLecturers(@RequestBody Lecturers lecturers) {
        lecturersService.addLecturers(lecturers);
    }

    @GetMapping
    public List<Lecturers> getLecturers() {
        return lecturersService.getLecturers();
    }
}
