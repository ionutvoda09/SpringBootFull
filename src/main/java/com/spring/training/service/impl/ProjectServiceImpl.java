package com.spring.training.service.impl;

import com.spring.training.components.Bill;
import com.spring.training.dto.EmployeeSummaryDto;
import com.spring.training.dto.ProjectDto;
import com.spring.training.model.Employee;
import com.spring.training.model.Project;
import com.spring.training.repository.EmployeeRepository;
import com.spring.training.repository.ProjectRepository;
import com.spring.training.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private Bill bill;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, EmployeeRepository employeeRepository, ModelMapper mapper, Bill bill) {
        this.projectRepository = projectRepository;
        this.modelMapper = mapper;
        this.employeeRepository = employeeRepository;
        this.bill = bill;
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        Project entity = modelMapper.map(projectDto, Project.class);
        bill.billingService(projectDto.getProjectName());
        return modelMapper.map(projectRepository.save(entity), ProjectDto.class);
    }

    @Override
    public Set<ProjectDto> findAll() {
        Set<ProjectDto> result = new HashSet<>();
        projectRepository.findAll().forEach(project -> result.add(modelMapper.map(project, ProjectDto.class)));

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<ProjectDto> addEmployee(Integer projectId, EmployeeSummaryDto employeeSummaryDto) {
        Optional<ProjectDto> result = Optional.empty();

        Optional<Project> project = projectRepository.findById(projectId);
        Optional<Employee> employee = employeeRepository.findById(employeeSummaryDto.getId());

        if(project.isPresent() && employee.isPresent()){

            project.get().getEmployees().add(employee.get());
            employee.get().getProjects().add(project.get());

            result = Optional.of(modelMapper.map(project.get(), ProjectDto.class));
        }
        return result;
    }

}
