package com.petrov.springboot.service;

import com.petrov.springboot.model.Worker;
import com.petrov.springboot.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private static final Logger log = LoggerFactory.getLogger(WorkerService.class);

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker findById(Long id){
        log.info("IN WorkerService getById {}", id);
        return workerRepository.findById(id).orElse(null);
    }

    public List<Worker> findAll(){
        log.info("IN WorkerService getAll");
        return workerRepository.findAll();
    }

    public Worker saveWorker(Worker worker){
        log.info("IN WorkerService save {}", worker);
        return workerRepository.save(worker);
    }

    public void deleteById(Long id){
        log.info("IN WorkerServiceImpl delete {}", id);
        workerRepository.deleteById(id);
    }
}