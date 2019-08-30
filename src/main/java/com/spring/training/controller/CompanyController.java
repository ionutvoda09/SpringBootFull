package com.spring.training.controller;

import com.spring.training.dto.CompanyDetailDto;
import com.spring.training.dto.CompanySummaryDto;
import com.spring.training.dto.CompanyUpdateDto;
import com.spring.training.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/showAll")
    public ResponseEntity<Set<CompanySummaryDto>> getCompanies() {
        Set<CompanySummaryDto> companyList = service.findAllCompanies();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<CompanyDetailDto>> findById(@PathVariable @NotNull Integer id){
        Optional<CompanyDetailDto> company = service.findById(id);

        return company.isPresent() ?
                new ResponseEntity<>(company, HttpStatus.OK) :
                    new ResponseEntity("id Not found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDetailDto> create(@Valid @RequestBody CompanyDetailDto companyDetailDto) {
        return ResponseEntity.ok(service.create(companyDetailDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<CompanyDetailDto>> delete(@PathVariable @NotNull Integer id) {

        Optional<CompanyDetailDto> removedCompany = service.deleteById(id);

        /**Lambda solution -> Much better*/
        /*return removedEmployee.isPresent() ?
                new ResponseEntity<>(removedEmployee, HttpStatus.OK) : new ResponseEntity("id not found", HttpStatus.NOT_FOUND);*/

        /**Classic way -> replace with lambda*/
        if (removedCompany.isPresent())
            return new ResponseEntity<>(removedCompany, HttpStatus.OK);

        return new ResponseEntity("id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/edit")
    public ResponseEntity<Optional<CompanyDetailDto>> update(@Valid @RequestBody CompanyUpdateDto companyUpdateDto) {
        Optional<CompanyDetailDto> updatedCompany = service.update(companyUpdateDto);
        return updatedCompany.isPresent() ?
                new ResponseEntity(updatedCompany, HttpStatus.OK) : new ResponseEntity("id not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findByEmployeeId/{id}")
    public ResponseEntity<Optional<CompanyDetailDto>> findByEmployeeId(@PathVariable @NotNull Integer id){
        Optional<CompanyDetailDto> company = service.findByEmployeeId(id);

        return company.isPresent() ?
                new ResponseEntity<>(company, HttpStatus.OK) :
                new ResponseEntity("id Not found!", HttpStatus.NOT_FOUND);
    }
}
