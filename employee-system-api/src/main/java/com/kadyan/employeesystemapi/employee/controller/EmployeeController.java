package com.kadyan.employeesystemapi.employee.controller;

import com.kadyan.employeesystemapi.employee.model.EmployeeModel;
import com.kadyan.employeesystemapi.employee.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/addData")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel)
    {
        return employeeService.addEmployee(employeeModel);
    }

    @GetMapping("/getData")
    public List<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
         deleted = employeeService.delEmployee(id);
         Map<String,Boolean> res = new HashMap<>();
         res.put("Deleted", deleted);
         return ResponseEntity.ok(res);

    }

    @GetMapping("/getData/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id)
    {
        EmployeeModel employeeModel = null;
        employeeModel = employeeService.getEmployeeById(id);
        return  ResponseEntity.ok(employeeModel);
    }

    @PutMapping("/putData/{id}")
    public  ResponseEntity<EmployeeModel> putData(@PathVariable Long id, @RequestBody EmployeeModel employeeModel){
            employeeModel = employeeService.updateEmployee(id, employeeModel);
            return ResponseEntity.ok(employeeModel);
    }
}
