package com.spring.training.repository;

import com.spring.training.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {

    @Query("select company from Company company join company.employees employees where employees.id = :employeeId")
    Optional<Company> findByEmployeeID(@Param("employeeId") Integer employeeId);
}
