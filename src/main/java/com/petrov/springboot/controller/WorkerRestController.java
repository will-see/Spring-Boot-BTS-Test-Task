package com.petrov.springboot.controller;

import com.petrov.springboot.model.Worker;
import com.petrov.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerRestController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Worker> getWorker(@PathVariable("id") Long workerId) {
        if (workerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Worker worker = this.workerService.findById(workerId);

        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Worker> saveWorker(@RequestBody @Valid Worker worker) {
        HttpHeaders headers = new HttpHeaders();

        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.workerService.saveWorker(worker);
        return new ResponseEntity<>(worker, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Worker> updateWorker(@RequestBody @Valid Worker worker, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.workerService.saveWorker(worker);

        return new ResponseEntity<>(worker, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Worker> deleteWorker(@PathVariable("id") Long id) {
        Worker worker = this.workerService.findById(id);

        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.workerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = this.workerService.findAll();

        if (workers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workers, HttpStatus.OK);
    }
}
