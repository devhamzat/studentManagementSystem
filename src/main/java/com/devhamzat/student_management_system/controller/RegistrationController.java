package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courseregistration")
public class RegistrationController {
   public RegistrationService registrationService;

}
