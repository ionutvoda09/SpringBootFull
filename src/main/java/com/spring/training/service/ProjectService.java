package com.spring.training.service;

import com.spring.training.dto.EmployeeSummaryDto;
import com.spring.training.dto.ProjectDto;

import java.util.Optional;
import java.util.Set;

public interface ProjectService {

    ProjectDto create(ProjectDto projectDto);

    Set<ProjectDto> findAll();

    Optional<ProjectDto> addEmployee(Integer projectId, EmployeeSummaryDto employeeSummaryDto);
}
