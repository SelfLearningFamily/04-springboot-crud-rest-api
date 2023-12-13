package com.zbrickx.crudemployee.service;

import com.zbrickx.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save( Employee employee);
    Boolean deleteById(int id);
}
