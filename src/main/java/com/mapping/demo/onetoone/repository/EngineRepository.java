package com.mapping.demo.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.demo.onetoone.entity.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, String> {
}
