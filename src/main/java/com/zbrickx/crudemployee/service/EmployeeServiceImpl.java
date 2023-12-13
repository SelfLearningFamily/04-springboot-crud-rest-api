package com.zbrickx.crudemployee.service;

import com.zbrickx.crudemployee.dao.EmployeeDao;
import com.zbrickx.crudemployee.dao.EmployeeDaoImpl;
import com.zbrickx.crudemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public  EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
