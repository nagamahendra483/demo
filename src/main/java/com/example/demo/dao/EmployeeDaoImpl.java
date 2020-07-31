package com.example.demo.dao;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl {
    @Autowired
    private EmployeeDAO employeeDAO;

    public List<EmployeeBean> findAll(){
        List<EmployeeEntity> employeeEntities=employeeDAO.findAll();
        List<EmployeeBean> employeeBeans=new ArrayList<>();
        for (EmployeeEntity employeeEntity :
                employeeEntities) {
            employeeBeans.add(convertEntityToBean(employeeEntity));
        }
        return  employeeBeans;
    }

    public EmployeeBean findById(Integer id){
        if(employeeDAO.existsById(id)) {
            return convertEntityToBean(employeeDAO.findById(id).get());
        }
        return null;
    }

    public EmployeeBean delete(Integer id){
        if(employeeDAO.existsById(id)){
            EmployeeBean employeeBean=findById(id);
            employeeDAO.deleteById(id);
            return employeeBean;
        }
        return null;
    }

    public EmployeeBean save(EmployeeBean employeeBean){
        EmployeeEntity employeeEntity=convertBeanToEntity(employeeBean);
        employeeEntity=employeeDAO.save(employeeEntity);
        return convertEntityToBean(employeeEntity);
    }

    public EmployeeBean update(EmployeeBean employeeBean){
        if(employeeDAO.existsById(employeeBean.getId())){
            return convertEntityToBean(employeeDAO.save(convertBeanToEntity(employeeBean)));
        }
        return null;

    }

    public EmployeeBean convertEntityToBean(EmployeeEntity employeeEntity){
        EmployeeBean employeeBean=new EmployeeBean();
        BeanUtils.copyProperties(employeeEntity,employeeBean);
        return  employeeBean;
    }

    public EmployeeEntity convertBeanToEntity(EmployeeBean employeeBean){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employeeBean,employeeEntity);
        return  employeeEntity;
    }
    
}
