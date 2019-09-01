package com.spring.training.dto;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CompanyUpdateDto {

    @NotNull
    private Integer id;

    private Optional<String> name;

    private Optional<String> registrationNumber;

    private Optional<String> address;

    private Optional<String> phoneNumber;

    private Optional<String> email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Optional<String> registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }
}
