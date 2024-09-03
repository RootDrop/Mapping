package com.mapping.demo.manytomany.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.manytomany.request.SaveProjectRequest;
import com.mapping.demo.manytomany.response.GetProjectResponse;
import com.mapping.demo.manytomany.response.SaveProjectResponse;
import com.mapping.demo.manytomany.service.ProjectService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {

  private ProjectService projectService;

  @PostMapping("/")
  public ResponseEntity<SaveProjectResponse> saveProject(@RequestBody SaveProjectRequest saveProjectRequest){
    SaveProjectResponse saveProjectResponse = projectService.saveProject(saveProjectRequest);
    return new ResponseEntity<>(saveProjectResponse, HttpStatus.OK);
  }

  @GetMapping("/get")
  public ResponseEntity<GetProjectResponse> getProject(@RequestParam String id){
    GetProjectResponse getProjectResponse = projectService.getProject(id);
    return new ResponseEntity<>(getProjectResponse, HttpStatus.OK);
  }
}
