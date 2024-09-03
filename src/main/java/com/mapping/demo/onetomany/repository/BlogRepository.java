package com.mapping.demo.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.demo.onetomany.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {


}
