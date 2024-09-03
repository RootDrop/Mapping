package com.mapping.demo.onetoone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.onetoone.request.SaveEngineRequest;
import com.mapping.demo.onetoone.response.GetEngineResponse;
import com.mapping.demo.onetoone.response.SaveEngineResponse;
import com.mapping.demo.onetoone.service.EngineService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/engine")
@AllArgsConstructor
public class EngineController {

  private EngineService engineService;

  @PostMapping("/")
  public ResponseEntity<SaveEngineResponse> saveEngine(@RequestBody SaveEngineRequest saveEngineRequest){
    SaveEngineResponse saveEngineResponse = engineService.saveEngine(saveEngineRequest);
    return new ResponseEntity<>(saveEngineResponse, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<GetEngineResponse> getEngine(@RequestParam String id){
    GetEngineResponse getEngineResponse = engineService.getEngine(id);
    return new ResponseEntity<>(getEngineResponse, HttpStatus.OK);
  }
}
