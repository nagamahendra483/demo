package com.example.demo.dao;

import com.example.demo.entity.EmployeeEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = EmployeeEntity.class,idClass = Integer.class)
public interface EmployeeDAO {
    public List<EmployeeEntity> findAll();
    public Optional<EmployeeEntity> findById(Integer id);
    public  void deleteById(Integer id);
    public EmployeeEntity save(EmployeeEntity employeeEntity);
    public boolean existsById(Integer id);
}
