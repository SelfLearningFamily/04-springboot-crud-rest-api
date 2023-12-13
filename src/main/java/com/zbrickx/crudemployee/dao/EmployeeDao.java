package com.zbrickx.crudemployee.dao;

import com.zbrickx.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    //select / get
    List<Employee> findAll();
    Employee findById(int id);
    Employee save( Employee employee);
    void deleteById(Employee employee);
    //create / insert
    //delete
    //add
}
