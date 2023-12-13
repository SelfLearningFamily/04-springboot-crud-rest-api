package com.zbrickx.crudemployee.service;


import com.zbrickx.crudemployee.dao.EmployeeRepository;
import com.zbrickx.crudemployee.entity.Employee;
import com.zbrickx.crudemployee.rest.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepo;

    public  EmployeeServiceImpl(EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        Optional<Employee> result = employeeRepo.findById(id);
        if(result.isPresent())
            employee = result.get();
         else
             throw new EmployeeNotFoundException("Employee not found");
        return employee;
    }

    //@Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

   //@Transactional
    @Override
    public Boolean deleteById(int id) {
        Employee employee = findById(id);
        if(employee == null)
            return false;
       employeeRepo.deleteById(id);
        return true;
    }
}
