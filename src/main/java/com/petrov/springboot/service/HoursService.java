package com.petrov.springboot.service;

import com.petrov.springboot.model.Hours;
import com.petrov.springboot.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoursService {

    private final HoursRepository hoursRepository;

    @Autowired
    public HoursService(HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
    }

    public Hours findById(Long id){
        return hoursRepository.findById(id).orElse(null);
    }
    public List<Hours> findByWorkerId(Long workerId){
        return hoursRepository.findByWorkerId(workerId);
    }

    public List<Hours> findAll(){
        return hoursRepository.findAll();
    }

    public Hours saveHours(Hours hours){
        return hoursRepository.save(hours);
    }

    public void deleteById(Long id){
        hoursRepository.deleteById(id);
    }
}