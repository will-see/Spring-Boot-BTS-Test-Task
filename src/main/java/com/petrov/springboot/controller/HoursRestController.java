package com.petrov.springboot.controller;

import com.petrov.springboot.model.Hours;
import com.petrov.springboot.service.HoursService;
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
@RequestMapping("/hours")
public class HoursRestController {

    @Autowired
    private HoursService hoursService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Hours>> getHoursByWorkerId(@PathVariable("id") Long workerId) {

        List<Hours> hours = this.hoursService.findByWorkerId(workerId);

        if (hours.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hours, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hours> saveHours(@RequestBody @Valid Hours hours) {
        HttpHeaders headers = new HttpHeaders();

        if (hours == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.hoursService.saveHours(hours);
        return new ResponseEntity<>(hours, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hours> updateHours(@RequestBody @Valid Hours hours, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (hours == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.hoursService.saveHours(hours);

        return new ResponseEntity<>(hours, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hours> deleteHours(@PathVariable("id") Long id) {
        Hours hours = this.hoursService.findById(id);

        if (hours == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.hoursService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Hours>> getAllHours() {
        List<Hours> hours = this.hoursService.findAll();

        if (hours.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hours, HttpStatus.OK);
    }
}
