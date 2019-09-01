package com.spring.training.controller;

import com.spring.training.dto.EmployeeSummaryDto;
import com.spring.training.dto.ProjectDto;
import com.spring.training.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private ProjectService service;

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping("/showAll")
    public ResponseEntity<Set<ProjectDto>> getCompanies() {
        Set<ProjectDto> projectList = service.findAll();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> create(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(service.create(projectDto));
    }

    /** Used to assign employee to project*/
    @PutMapping("/addEmployee/{projectId}")
    public ResponseEntity<Optional<ProjectDto>> addEmployee(@PathVariable @NotNull Integer projectId, @Valid @RequestBody EmployeeSummaryDto employeeSummaryDto) {
        return ResponseEntity.ok(service.addEmployee(projectId, employeeSummaryDto));
    }
}
