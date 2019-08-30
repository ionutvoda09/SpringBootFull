package com.spring.training.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SalaryDto {

    private Integer id;

    @NotNull
    @Min(value = 400)
    private Double value;

    private String currency;

    @JsonBackReference
    private EmployeeDetailDto employee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public EmployeeDetailDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDetailDto employee) {
        this.employee = employee;
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
