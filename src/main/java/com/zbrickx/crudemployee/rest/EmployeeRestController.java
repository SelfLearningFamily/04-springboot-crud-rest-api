package com.zbrickx.crudemployee.rest;

import com.zbrickx.crudemployee.dao.EmployeeDao;
import com.zbrickx.crudemployee.entity.Employee;
import com.zbrickx.crudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
