package com.petrov.springboot.service;

import com.petrov.springboot.model.Worker;
import com.petrov.springboot.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker findById(Long id){
        return workerRepository.findById(id).orElse(null);
    }

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker saveWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public void deleteById(Long id){
        workerRepository.deleteById(id);
    }
}