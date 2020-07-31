package com.example.demo.controller;

import com.example.demo.ExampleApplication;
import com.example.demo.bean.EmployeeBean;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public static final Logger log= LoggerFactory.getLogger(ExampleApplication.class);

    @GetMapping(value = "/getAllDetails")
    public ResponseEntity<List<EmployeeBean>> getAllDetails(){
        List<EmployeeBean> employeeBeans=employeeService.findAll();
        log.info(" All Employee Details Retrieved");
        return new ResponseEntity<List<EmployeeBean>>(employeeBeans,HttpStatus.OK);


    }

    @GetMapping(value = "/findById")
    public ResponseEntity<EmployeeBean> findById(@RequestParam("id") Integer id){
        EmployeeBean employeeBean=employeeService.findById(id);
        if(employeeBean != null){
            log.info("user retrieved with valid Id {}",id);
            return new ResponseEntity<EmployeeBean>(employeeBean,HttpStatus.OK);
        }else{
            log.warn("user tried to Retrieve With invalid Id {}",id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/delete")
    public ResponseEntity<EmployeeBean> delete(@RequestParam("id") Integer id){
        EmployeeBean employeeBean=employeeService.delete(id);
        if(employeeBean != null){
            log.info("user deleted account with id {}",id);
            return new ResponseEntity<EmployeeBean>(employeeBean,HttpStatus.OK);
        }else{
            log.warn("user tried to delete account with wrong id {}",id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/add")
    public ResponseEntity<EmployeeBean> addEmployee(@RequestParam("name") String name,
                            @RequestParam("sal") Double salary){
        EmployeeBean employeeBean=new EmployeeBean();
        employeeBean.setName(name);
        employeeBean.setSalary(salary);
        employeeBean=employeeService.save(employeeBean);
        log.info("new user added with id {}",employeeBean.getId());
        return new ResponseEntity<EmployeeBean>(employeeBean,HttpStatus.OK);
    }

    @GetMapping(value = "/update")
    public ResponseEntity<EmployeeBean> update(@RequestParam("id") Integer id,
                                               @RequestParam("name") String name,
                                               @RequestParam("sal") Double salary){
        EmployeeBean employeeBean=new EmployeeBean();
        employeeBean.setId(id);
        employeeBean.setName(name);
        employeeBean.setSalary(salary);
        employeeBean=employeeService.update(employeeBean);
        if(employeeBean != null) {
            log.info("user updated account with id {}",id);
            return new ResponseEntity<EmployeeBean>(employeeBean, HttpStatus.OK);
        }
        log.warn("user tried to update With invalid Id {}",id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
