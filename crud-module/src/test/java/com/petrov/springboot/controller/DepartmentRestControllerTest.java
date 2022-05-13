package com.petrov.springboot.controller;

import com.petrov.springboot.model.Department;
import com.petrov.springboot.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentRestControllerTest {

    @Autowired
    DepartmentService dService;

    @Autowired
    private DepartmentRestController controller;

    @Test
    public void testGetById(){
        assertNotNull(dService.findById(1L));
    }

    @Test
    @Transactional
    public void testUpdate(){
        Department department = dService.findById(1L);
        department.setDepartment("closed");
        dService.saveDepartment(department);
        assertEquals("closed", dService.findById(1L).getDepartment());
    }

    @Test
    @Transactional
    public void testAdd(){
        int startSize = dService.findAll().size();
        Department department = new Department();
        department.setDepartment("newOffice");
        dService.saveDepartment(department);
        assertTrue(dService.findAll().size()>startSize);
    }

    @Test
    @Transactional
    public void testGetAll(){
        List<Department> departments = dService.findAll();
        assertTrue(departments.size()>0);
    }

    @Test
    @Transactional
    public void testDelete(){
        dService.deleteById(1L);
        assertNull(dService.findById(1L));
    }

}