package com.shunya.spring_samples.controller;

import com.shunya.spring_samples.model.DepartmentModel;
import com.shunya.spring_samples.service.DepartmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    
    @PostMapping("/")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentModel department){

        departmentService.createDepartment(department);
        return ResponseEntity.ok().body("Saved");
    }
}
