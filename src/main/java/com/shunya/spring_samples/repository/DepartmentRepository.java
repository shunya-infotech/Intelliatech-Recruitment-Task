package com.shunya.spring_samples.repository;

import javax.transaction.Transactional;

import com.shunya.spring_samples.model.DepartmentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Short>{
    
}
