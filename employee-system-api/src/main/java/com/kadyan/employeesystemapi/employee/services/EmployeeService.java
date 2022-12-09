package com.kadyan.employeesystemapi.employee.services;

import com.kadyan.employeesystemapi.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel);

    EmployeeModel addEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getEmployees();

    boolean delEmployee(Long id);


    EmployeeModel getEmployeeById(Long id);
}
