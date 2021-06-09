package com.shunya.spring_samples.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.shunya.spring_samples.exception.FileNotAnImageException;
import com.shunya.spring_samples.exception.FileSizeExceedException;
import com.shunya.spring_samples.model.DepartmentModel;
import com.shunya.spring_samples.model.EmployeeModel;
import com.shunya.spring_samples.repository.DepartmentRepository;
import com.shunya.spring_samples.repository.EmployeeRepository;
import com.shunya.spring_samples.service.EmployeeService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeModel createEmployee(Short departmentId, EmployeeModel employee, MultipartFile image) throws IOException {

        if (!(image.getContentType().split("/")[0]).equals("image"))
            throw new FileNotAnImageException("The file is not an image");

        if (image.getSize() > (2 * 2048 * 2048))
            throw new FileSizeExceedException("File must be less then 2 MB");

        DepartmentModel department = departmentRepository.findById(departmentId).get();
        if( department == null)
             throw new EntityNotFoundException("Department not found with given id");

        employee.setDepartment(department);

        /*
         * more checks need to be added here for employee and appropriate exceptions
         * must be thrown.
         */

        employee = employeeRepository.save(employee);

        File imageDir = new File("images/" + employee.getId());
        if (!imageDir.exists())
            imageDir.mkdirs();

        String filename = imageDir.getAbsolutePath() + "/profile-image"
                + image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));

        try (InputStream is = image.getInputStream()) {
            Files.copy(is, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
        }

        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployeesForCity(String city) {

        /*
         * checks needed to be added here for city value and appropriate exceptions must
         * be thrown.
         */

        return employeeRepository.getAllEmployeesForCity(city);
    }

    @Override
    public List<EmployeeModel> getAllEmployeesForDepartment(String departmentName) {

        /*
         * check needed to be added here for department exists or not and appropriate
         * exception(EntityNotFoundException) must be thrown.
         */

        return employeeRepository.getAllEmployeesForDepartment(departmentName);
    }

    @Override
    public void deleteAllEmployeesForDepartment(Integer departmentId) {

        employeeRepository.deleteAllEmployeesForDepartment(departmentId);
    }
}
