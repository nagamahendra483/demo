package com.example.demo;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
class ExampleApplicationTests {
	@Autowired
	private EmployeeService employeeService;
	@Test
	@DisplayName(value = "findall")
	void contextLoads() {
		Assertions.assertEquals("Hello",employeeService.findAll().get(2).getName());
		Assertions.assertNotNull(employeeService.findAll());



	}
	@Test
	@DisplayName(value = "findbyid")
	void findById(){
		Assertions.assertEquals("mahi",employeeService.findById(3).getName());
	}

	@Test
	@DisplayName(value = "save")
	void save(){
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setName("Hello");
		employeeBean.setSalary(45000.0);
		Integer id=employeeService.save(employeeBean).getId();
		Assertions.assertNotNull(id);

	}

	@Test
	@DisplayName(value = "update")
	void update(){
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setId(1);
		employeeBean.setName("reddy");
		employeeBean.setSalary(45000.0);
		employeeService.update(employeeBean);
		Assertions.assertEquals("reddy",employeeService.findById(employeeBean.getId()).getName());
	}


	@Test
	@DisplayName(value = "delete")
	void delete(){
		Assertions.assertEquals("nani",employeeService.delete(2).getName());
		Assertions.assertNull(employeeService.delete(5));
	}

}
