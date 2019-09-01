package com.spring.training.dto;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class EmployeeSaveDto {

    @NotNull
    private Integer id;
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<String> email;
    private Optional<String> address;
    private Optional<String> phone;
    private Optional<Long> personalNumericCode;
    private Optional<Boolean> isHired;
    private Optional<Integer> companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    public Optional<String> getPhone() {
        return phone;
    }

    public void setPhone(Optional<String> phone) {
        this.phone = phone;
    }

    public Optional<Long> getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(Optional<Long> personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public Optional<Boolean> getIsHired() {
        return isHired;
    }

    public void setIsHired(Optional<Boolean> isHired) {
        this.isHired = isHired;
    }

    public Optional<Integer> getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Optional<Integer> companyId) {
        this.companyId = companyId;
    }
}
