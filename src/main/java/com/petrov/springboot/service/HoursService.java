package com.petrov.springboot.service;

import com.petrov.springboot.model.Hours;
import com.petrov.springboot.repository.HoursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoursService {

    private static final Logger log = LoggerFactory.getLogger(WorkerService.class);

    private final HoursRepository hoursRepository;

    @Autowired
    public HoursService(HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
    }

    public Hours findById(Long id){
        log.info("IN HoursService getById {}", id);
        return hoursRepository.findById(id).orElse(null);
    }
    public List<Hours> findByWorkerId(Long workerId){
        log.info("IN HoursService getByWorkerId {}", workerId);
        return hoursRepository.findByWorkerId(workerId);
    }

    public List<Hours> findAll(){
        log.info("IN HoursService All");
        return hoursRepository.findAll();
    }

    public Hours saveHours(Hours hours){
        log.info("IN HoursService save");
        return hoursRepository.save(hours);
    }

    public void deleteById(Long id){
        log.info("IN HoursService deleteById", id);
        hoursRepository.deleteById(id);
    }
}