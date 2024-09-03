package com.mapping.demo.onetoone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.onetoone.request.SaveMotorRequest;
import com.mapping.demo.onetoone.response.GetMotorResponse;
import com.mapping.demo.onetoone.response.SaveMotorResponse;
import com.mapping.demo.onetoone.service.MotorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/motor")
@AllArgsConstructor
public class MotorController {

  private MotorService motorService;

  @PostMapping("/")
  public ResponseEntity<SaveMotorResponse> saveMotor(@RequestBody SaveMotorRequest saveMotorRequest) {
    SaveMotorResponse saveMotorResponse = motorService.saveMotor(saveMotorRequest);
    return new ResponseEntity<>(saveMotorResponse, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<GetMotorResponse> getMotor(@RequestParam String id){
    GetMotorResponse getMotorResponse = motorService.getMotor(id);
    return new ResponseEntity<>(getMotorResponse, HttpStatus.OK);
  }
}
