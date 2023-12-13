package com.zbrickx.crudemployee.rest;

import com.zbrickx.crudemployee.entity.Employee;
import com.zbrickx.crudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService serviceEmployee;

    @Autowired
    public EmployeeRestController(EmployeeService serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return serviceEmployee.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee requireEmployee = serviceEmployee.findById(id);
        if (requireEmployee == null)
            throw  new EmployeeNotFoundException("Employee Id not found: " + id);
        return requireEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0); // setting the default value to id to avoid
        //override some existing data

        Employee newEmp = serviceEmployee.save(employee);

        return newEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = serviceEmployee.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Boolean isDeleted  = serviceEmployee.deleteById(id);
        if(isDeleted)
            return "Employee with id: " + id + " successfully deleted";
        else
            return "Employee with id: " + id + " does not exist in our database";
    }


}
