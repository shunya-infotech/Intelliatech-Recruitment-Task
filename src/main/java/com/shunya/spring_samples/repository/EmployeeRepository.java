package com.shunya.spring_samples.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.shunya.spring_samples.model.EmployeeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    @Query(nativeQuery = true, value = "select * from employee where city = :city")
    public List<EmployeeModel> getAllEmployeesForCity(String city);

    @Query(nativeQuery = true, value = "select * from employee, department where department.id = employee.department_id "
            + " and department.name = :departmentName")
    public List<EmployeeModel> getAllEmployeesForDepartment(String departmentName);

    @Modifying
    @Query(nativeQuery = true, value = "delete from employee where department_id = ?")
    public Integer deleteAllEmployeesForDepartment(Integer departmentId);
}
