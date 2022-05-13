package com.petrov.springboot.controller;

import com.petrov.springboot.model.Department;
import com.petrov.springboot.service.DepartmentService;
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
@RequestMapping("/departments")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Long departmentId) {
        if (departmentId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Department department = this.departmentService.findById(departmentId);

        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Department> saveDepartment(@RequestBody @Valid Department department) {
        HttpHeaders headers = new HttpHeaders();

        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.departmentService.saveDepartment(department);
        return new ResponseEntity<>(department, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Department> updateDepartment(@RequestBody @Valid Department department, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.departmentService.saveDepartment(department);

        return new ResponseEntity<>(department, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Department> deleteDeartment(@PathVariable("id") Long id) {
        Department department = this.departmentService.findById(id);

        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.departmentService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> departments = this.departmentService.findAll();

        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
