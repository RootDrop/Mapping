package com.mapping.demo.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.demo.manytomany.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
