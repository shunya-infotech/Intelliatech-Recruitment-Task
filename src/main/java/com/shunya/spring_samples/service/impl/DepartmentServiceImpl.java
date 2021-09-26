package com.shunya.spring_samples.service.impl;

import com.shunya.spring_samples.model.DepartmentModel;
import com.shunya.spring_samples.repository.DepartmentRepository;
import com.shunya.spring_samples.service.DepartmentService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    
    @Override
    public DepartmentModel createDepartment(DepartmentModel department) {
        
        return departmentRepository.save(department);
    }
}
