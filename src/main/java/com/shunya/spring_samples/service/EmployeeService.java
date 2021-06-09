package com.shunya.spring_samples.service;

import java.io.IOException;
import java.util.List;

import com.shunya.spring_samples.model.EmployeeModel;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

    public EmployeeModel createEmployee(EmployeeModel employee, MultipartFile image) throws IOException;

    public List<EmployeeModel> getAllEmployeesForCity(String city);

    public List<EmployeeModel> getAllEmployeesForDepartment(String departmentName);

    public void deleteAllEmployeesForDepartment(Integer departmentId);
}
