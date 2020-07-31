package com.example.demo.service;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.dao.EmployeeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @Override
    public List<EmployeeBean> findAll() {
        return employeeDaoImpl.findAll();
    }

    @Override
    public EmployeeBean findById(Integer id) {
        return employeeDaoImpl.findById(id);
    }

    @Override
    public EmployeeBean delete(Integer id) {
        return employeeDaoImpl.delete(id);
    }

    @Override
    public EmployeeBean save(EmployeeBean employeeBean) {
        return employeeDaoImpl.save(employeeBean);
    }

    @Override
    public EmployeeBean update(EmployeeBean employeeBean) {
        return employeeDaoImpl.update(employeeBean);
    }
}
