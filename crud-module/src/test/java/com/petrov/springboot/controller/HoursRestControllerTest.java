package com.petrov.springboot.controller;

import com.petrov.springboot.model.Hours;
import com.petrov.springboot.service.HoursService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HoursRestControllerTest {

    @Autowired
    HoursService hService;

    @Autowired
    private HoursRestController controller;

    @Test
    public void testGetById(){
        assertNotNull(hService.findById(1L));
    }

    @Test
    public void testGetByWorkerId(){
        assertNotNull(hService.findByWorkerId(1L));
    }

    @Test
    @Transactional
    public void testUpdate(){
        Hours hours = hService.findById(1L);
        hours.setEndTime(20);
        hService.saveHours(hours);
        assertEquals(20, hService.findById(1L).getEndTime());
    }

    @Test
    @Transactional
    public void testAdd(){
        int startSize = hService.findAll().size();
        Hours hours = new Hours();
        hours.setStartTime(0);
        hours.setEndTime(24);
        hours.setWorkerId(1L);
        hService.saveHours(hours);
        assertTrue(hService.findAll().size()>startSize);
    }

    @Test
    @Transactional
    public void testGetAll(){
        List<Hours> hours = hService.findAll();
        assertTrue(hours.size()>0);
    }

    @Test
    @Transactional
    public void testDelete(){
        hService.deleteById(1L);
        assertNull(hService.findById(1L));
    }

}