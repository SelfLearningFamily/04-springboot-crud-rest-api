package com.zbrickx.crudemployee.dao;

import com.zbrickx.crudemployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        //execute query
        List<Employee> employees =query.getResultList();
        //return result
        return employees;
    }
}
