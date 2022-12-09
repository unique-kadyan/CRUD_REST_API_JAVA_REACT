package com.kadyan.employeesystemapi.employee.services;

import com.kadyan.employeesystemapi.employee.entity.EmployeeEntity;
import com.kadyan.employeesystemapi.employee.model.EmployeeModel;
import com.kadyan.employeesystemapi.employee.repository.EmployeesRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeesRepo employeesRepo;
    public  EmployeeServiceImpl(EmployeesRepo employeesRepo)
    {
        this.employeesRepo = employeesRepo;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = employeesRepo.findById(id).get();
        employeeEntity.setEmail(employeeModel.getEmail());
        employeeEntity.setFullname(employeeModel.getFullname());
        employeeEntity.setMobile(employeeModel.getMobile());
        employeesRepo.save(employeeEntity);
        return employeeModel;
    }

    @Override
    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel, employeeEntity);
        employeesRepo.save(employeeEntity);
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeesRepo.findAll();
        List<EmployeeModel> employees = employeeEntities.stream().map(emp -> new EmployeeModel(emp.getId(),emp.getFullname(),emp.getEmail(),emp.getMobile())).collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean delEmployee(Long id) {
        EmployeeEntity emp = employeesRepo.findById(id).get();
        employeesRepo.delete(emp);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        EmployeeEntity emp = employeesRepo.findById(id).get();
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(emp, employeeModel);
        return employeeModel;
    }
}
