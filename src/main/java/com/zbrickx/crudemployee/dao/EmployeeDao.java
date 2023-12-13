package com.zbrickx.crudemployee.dao;

import com.zbrickx.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    //select / get
    List<Employee> findAll();
    //create / insert
    //delete
    //add
}
