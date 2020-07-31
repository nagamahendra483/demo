package com.example.demo.service;

import com.example.demo.bean.EmployeeBean;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeBean> findAll();
    public EmployeeBean findById(Integer id);
    public EmployeeBean delete(Integer id);
    public EmployeeBean save(EmployeeBean employeeBean);
    public EmployeeBean update(EmployeeBean employeeBean);
}
