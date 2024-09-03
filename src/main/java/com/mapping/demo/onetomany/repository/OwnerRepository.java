package com.mapping.demo.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.demo.onetomany.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
}
