package com.petrov.springboot.service;

import com.petrov.springboot.model.Department;
import com.petrov.springboot.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(WorkerService.class);

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository workerRepository) {
        this.departmentRepository = workerRepository;
    }

    public Department findById(Long id){
        log.info("IN DepartmentService getById", id);
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> findAll(){
        log.info("IN DepartmentService getAll");
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department){
        log.info("IN DepartmentService save");
        return departmentRepository.save(department);
    }

    public void deleteById(Long id){
        log.info("IN DepartmentService deleteById", id);
        departmentRepository.deleteById(id);
    }
}