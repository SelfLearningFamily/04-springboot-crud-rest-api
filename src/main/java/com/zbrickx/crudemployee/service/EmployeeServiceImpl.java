package com.zbrickx.crudemployee.service;

import com.zbrickx.crudemployee.dao.EmployeeDao;
import com.zbrickx.crudemployee.dao.EmployeeDaoImpl;
import com.zbrickx.crudemployee.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

   @Transactional
    @Override
    public Boolean deleteById(int id) {
        Employee employee = findById(id);
        if(employee == null)
            return false;
        employeeDao.deleteById(employee);
        return true;
    }
}
