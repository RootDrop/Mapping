package com.mapping.demo.onetomany.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.onetomany.request.SaveBlogRequest;
import com.mapping.demo.onetomany.response.GetBlogResponse;
import com.mapping.demo.onetomany.response.SaveBlogResponse;
import com.mapping.demo.onetomany.service.BlogService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {

  private BlogService blogService;

  @PostMapping("/")
  public ResponseEntity<SaveBlogResponse> saveBlog(@RequestBody SaveBlogRequest saveBlogRequest){
    SaveBlogResponse saveBlogResponse = blogService.saveBlog(saveBlogRequest);
    return new ResponseEntity<>(saveBlogResponse, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<GetBlogResponse> getBlog(@RequestParam String id){
    GetBlogResponse getBlogResponse = blogService.getBlog(id);
    return new ResponseEntity<>(getBlogResponse, HttpStatus.OK);
  }
 }
