package com.spring.training.service.impl;

import com.spring.training.dto.CompanyDetailDto;
import com.spring.training.dto.CompanySummaryDto;
import com.spring.training.dto.CompanyUpdateDto;
import com.spring.training.model.Company;
import com.spring.training.repository.CompanyRepository;
import com.spring.training.service.CompanyService;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository repository;
    private ModelMapper modelMapper;

    //todo: OBSERVATIE:  Este recomandat sa folositi @Autowire pe constructor!
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper mapper) {
        this.repository = companyRepository;
        this.modelMapper = mapper;
    }

    @Override
    public Set<CompanySummaryDto> findAllCompanies() {
        Set<CompanySummaryDto> resultSet = new HashSet<>();
        repository.findAll().forEach(company -> resultSet.add(modelMapper.map(company, CompanySummaryDto.class)));

        return resultSet;
    }

    @Override
    public CompanyDetailDto create(CompanyDetailDto dataFromFE) {
        Company entity = modelMapper.map(dataFromFE, Company.class);
        return modelMapper.map(repository.save(entity), CompanyDetailDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<CompanyDetailDto> update(CompanyUpdateDto dataFromFE) {
        Optional<Company> entity = repository.findById(dataFromFE.getId());
        if(entity.isPresent()){
            if(Optional.ofNullable(dataFromFE.getAddress()).isPresent())
                entity.get().setAddress(dataFromFE.getAddress().get());
            if(Optional.ofNullable(dataFromFE.getEmail()).isPresent())
                entity.get().setEmail(dataFromFE.getEmail().get());
            if(Optional.ofNullable(dataFromFE.getPhoneNumber()).isPresent())
                entity.get().setPhoneNumber(dataFromFE.getPhoneNumber().get());
            if(Optional.ofNullable(dataFromFE.getRegistrationNumber()).isPresent())
                entity.get().setRegistrationNumber(dataFromFE.getRegistrationNumber().get());
            if(Optional.ofNullable(dataFromFE.getName()).isPresent())
                entity.get().setName(dataFromFE.getName().get());

            return Optional.of(modelMapper.map(entity.get(), CompanyDetailDto.class));
        }
        return Optional.empty();
    }

    //todo -> explica de ce nu mai ai nevoie de else
    @Override
    public Optional<CompanyDetailDto> deleteById(Integer id) {
        Optional<Company> company = repository.findById(id);
        if(company.isPresent()){
            repository.deleteById(id);
            return Optional.of(modelMapper.map(company.get(), CompanyDetailDto.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<CompanyDetailDto> findById(Integer id) {
        Optional<Company> company = repository.findById(id);
        return company.isPresent() ? Optional.of(noModelMapperCompanyToDtoConvertor(company.get())) : Optional.empty();
    }

    @Override
    public Optional<CompanyDetailDto> findByEmployeeId(Integer employeeId) {
        Optional<Company> result = repository.findByEmployeeID(employeeId);

        return Optional.of(noModelMapperCompanyToDtoConvertor(result.get()));
    }

    //convertor din Company in CompanyDetailDto
    //todo -> explica
    private CompanyDetailDto noModelMapperCompanyToDtoConvertor(Company input){
        CompanyDetailDto dto = new CompanyDetailDto();

        //setName
        if (input.getName() != null)
            dto.setName(input.getName());
        //SetAddress
        if (input.getAddress() != null)
            dto.setAddress(input.getAddress());
        //SetEmail
        if (input.getEmail() != null)
            dto.setEmail(input.getEmail());
        //SetId
        if (input.getId() != null)
            dto.setId(input.getId());
        //SetRegistrationNumber
        if (input.getRegistrationNumber() != null)
            dto.setRegistrationNumber(input.getRegistrationNumber());
        //SetEmployee ID list
        //todo -> explica de ce in dto intoarcem doar lista cu id-uri ale employee
        if (input.getEmployees() != null){
            //Initialize list
            dto.setEmployees(new HashSet<>());
            //populate list with each employee ID
            input.getEmployees().forEach(employee -> dto.getEmployees().add(employee.getId()));
        }
        return dto;
    }
}
