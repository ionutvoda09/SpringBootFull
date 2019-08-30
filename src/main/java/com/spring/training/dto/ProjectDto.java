package com.spring.training.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

    private Integer id;
    private String projectName;
    private Set<EmployeeSummaryDto> employees = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<EmployeeSummaryDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeSummaryDto> employees) {
        this.employees = employees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
