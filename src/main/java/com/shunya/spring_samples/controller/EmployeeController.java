package com.shunya.spring_samples.controller;

import java.io.IOException;
import java.util.List;

import com.shunya.spring_samples.model.EmployeeModel;
import com.shunya.spring_samples.service.EmployeeService;
import com.shunya.spring_samples.util.response.ResponseWrapper;

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

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<?> createEmployee(@RequestParam("department-id") Short departmentId,
            @RequestPart("employee") EmployeeModel employee, @RequestPart("image") MultipartFile image)
            throws IOException {

        employee = employeeService.createEmployee(departmentId, employee, image);
        ResponseWrapper<EmployeeModel> createEmployeeResponse = new ResponseWrapper<>();
        
        createEmployeeResponse.setResponseSuccess(employee, "Created Successfully", null);
        return ResponseEntity.ok().body(createEmployeeResponse);
    }

    @GetMapping("/city")
    public ResponseEntity<?> getAllEmployeesForCity(@RequestParam("city") String city) {

        List<EmployeeModel> employees = employeeService.getAllEmployeesForCity(city);
        ResponseWrapper<List<EmployeeModel>> getAllEmployeesForCityResponse = new ResponseWrapper<>();

        getAllEmployeesForCityResponse.setResponseSuccess(employees, "Fetched All Employees for the given City", null);
        return ResponseEntity.ok().body(getAllEmployeesForCityResponse);
    }

    @GetMapping("/department")
    public ResponseEntity<?> getAllEmployeesForDepartment(@RequestParam("name") String departmentName) {

        List<EmployeeModel> employees = employeeService.getAllEmployeesForDepartment(departmentName);
        ResponseWrapper<List<EmployeeModel>> getAllEmployeesForDepartmentResponse = new ResponseWrapper<>();

        getAllEmployeesForDepartmentResponse.setResponseSuccess(employees, "Fetched All Employees the for given Department", null);
        return ResponseEntity.ok().body(getAllEmployeesForDepartmentResponse);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployeesForDepartment(@RequestParam("department-id") Integer departmentId) {

        employeeService.deleteAllEmployeesForDepartment(departmentId);
        return ResponseEntity.ok().body("Deleted All Employees for given Department");
    }
}
