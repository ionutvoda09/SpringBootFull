package com.spring.training.repository;

import com.spring.training.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
}
