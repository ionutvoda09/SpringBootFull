package com.spring.training.controller;

import java.util.List;
import java.util.Optional;

import com.spring.training.dto.EmployeeDetailDto;
import com.spring.training.dto.EmployeeSaveDto;
import com.spring.training.dto.EmployeeSummaryDto;
import com.spring.training.model.Employee;
import com.spring.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/showAll")
    public List<EmployeeSummaryDto> getEmployees() {
        List<EmployeeSummaryDto> employeesList = service.getEmployees();
        return employeesList;
    }

    @PostMapping("/save")
    public ResponseEntity create(@Valid @RequestBody EmployeeDetailDto employee) {
        return ResponseEntity.ok(service.save(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<EmployeeDetailDto>> delete(@PathVariable @NotNull Integer id) {

        Optional<EmployeeDetailDto> removedEmployee = service.delete(id);

        /**Lambda solution -> Much better*/
        /*return removedEmployee.isPresent() ?
                new ResponseEntity<>(removedEmployee, HttpStatus.OK) : new ResponseEntity("id not found", HttpStatus.NOT_FOUND);*/

        /**Classic way -> replace with lambda*/
        if (removedEmployee.isPresent()) {
            return new ResponseEntity<>(removedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity("id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/edit")
    public ResponseEntity<Optional<EmployeeDetailDto>> updatePut(@Valid @RequestBody EmployeeSaveDto employee) {
        Optional<EmployeeDetailDto> updatedEmployee = service.update(employee);
        return updatedEmployee.isPresent() ?
                new ResponseEntity(updatedEmployee, HttpStatus.OK) : new ResponseEntity("id not found", HttpStatus.NOT_FOUND);
    }

}
