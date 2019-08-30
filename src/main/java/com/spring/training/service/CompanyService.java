package com.spring.training.service;

import com.spring.training.dto.CompanyDetailDto;
import com.spring.training.dto.CompanySummaryDto;
import com.spring.training.dto.CompanyUpdateDto;

import java.util.Optional;
import java.util.Set;

public interface CompanyService {

    Set<CompanySummaryDto> findAllCompanies();

    CompanyDetailDto create(CompanyDetailDto company);

    Optional<CompanyDetailDto> update(CompanyUpdateDto companyUpdateDto);

    Optional<CompanyDetailDto> deleteById(Integer id);

    Optional<CompanyDetailDto> findById(Integer id);

    Optional<CompanyDetailDto> findByEmployeeId(Integer employeeId);

}
