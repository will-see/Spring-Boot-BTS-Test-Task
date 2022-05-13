package com.petrov.springboot.controller;

import com.petrov.springboot.model.Worker;
import com.petrov.springboot.service.WorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class WorkerRestControllerTest {

    @Autowired
    WorkerService wService;

    @Autowired
    private WorkerRestController controller;

    @Test
    public void testGetById(){
        assertNotNull(wService.findById(1L));
    }

    @Test
    @Transactional
    public void testUpdate(){
        Worker worker = wService.findById(1L);
        worker.setFirstName("newName");
        wService.saveWorker(worker);
        assertEquals("newName", wService.findById(1L).getFirstName());
    }

    @Test
    @Transactional
    public void testAdd(){
        int startSize = wService.findAll().size();
        Worker worker = new Worker();
        worker.setFirstName("aaaa");
        worker.setLastName("bbbb");
        worker.setDepartment(1);
        wService.saveWorker(worker);
        assertTrue(wService.findAll().size()>startSize);
    }

    @Test
    @Transactional
    public void testGetAll(){
        List<Worker> workers = wService.findAll();
        assertTrue(workers.size()>0);
    }

    @Test
    @Transactional
    public void testDelete(){
        wService.deleteById(1L);
        assertNull(wService.findById(1L));
    }

}