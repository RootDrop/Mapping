package com.mapping.demo.manytomany.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.manytomany.request.SaveEmployeeRequest;
import com.mapping.demo.manytomany.response.GetEmployeeResponse;
import com.mapping.demo.manytomany.response.SaveEmployeeResponse;
import com.mapping.demo.manytomany.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @PostMapping("/")
  public ResponseEntity<SaveEmployeeResponse> saveEmployee(@RequestBody SaveEmployeeRequest saveEmployeeRequest) {
    SaveEmployeeResponse saveEmployeeResponse = employeeService.saveEmployee(saveEmployeeRequest);
    return new ResponseEntity<>(saveEmployeeResponse, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<GetEmployeeResponse> getEmployee(@RequestParam String id) {
    GetEmployeeResponse getEmployeeResponse = employeeService.getEmployee(id);
    return new ResponseEntity<>(getEmployeeResponse, HttpStatus.OK);
  }
}
