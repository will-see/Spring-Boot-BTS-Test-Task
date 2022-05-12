package com.petrov.springboot.service;

import com.petrov.springboot.model.Department;
import com.petrov.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository workerRepository) {
        this.departmentRepository = workerRepository;
    }

    public Department findById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }
}