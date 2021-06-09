package com.shunya.spring_samples.controller;

import java.io.IOException;

import com.shunya.spring_samples.model.EmployeeModel;
import com.shunya.spring_samples.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    @PostMapping(value= "/", consumes = {"multipart/form-data"})
    public ResponseEntity<?> createEmployee(@RequestPart("employee") EmployeeModel employee, @RequestPart("image") MultipartFile image) throws IOException{

        employeeService.createEmployee(employee, image);

        return ResponseEntity.ok().body("Name : " + image.getOriginalFilename() + ", Type : " + image.getContentType() + ", Size : " + image.getSize());
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getAllEmployeesForCity(@PathVariable("city") String city){

        employeeService.getAllEmployeesForCity(city);

        return ResponseEntity.ok().body("Fetched All Employees for given City");
    }

    @GetMapping("/{department-name}")
    public ResponseEntity<?> getAllEmployeesForDepartment(@PathVariable("department-name") String departmentName){

        employeeService.getAllEmployeesForDepartment(departmentName);

        return ResponseEntity.ok().body("Fetched All Employees for given City");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployeesForDepartment(@RequestParam("department_id") Integer departmentId){

        employeeService.deleteAllEmployeesForDepartment(departmentId);

        return ResponseEntity.ok().body("Deleted All Employees for given Department");
    }
}
