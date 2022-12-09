package com.kadyan.employeesystemapi.employee.repository;
import com.kadyan.employeesystemapi.employee.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepo extends JpaRepository<EmployeeEntity, Long> {
}
