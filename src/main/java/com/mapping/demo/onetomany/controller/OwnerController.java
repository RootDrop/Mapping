package com.mapping.demo.onetomany.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.onetomany.request.SaveOwnerRequest;
import com.mapping.demo.onetomany.response.GetOwnerResponse;
import com.mapping.demo.onetomany.response.SaveOwnerResponse;
import com.mapping.demo.onetomany.service.OwnerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/owner")
@AllArgsConstructor
public class OwnerController {

  private OwnerService ownerService;

  @PostMapping("/")
  public ResponseEntity<SaveOwnerResponse> saveOwner(@RequestBody SaveOwnerRequest saveOwnerRequest){
    SaveOwnerResponse saveOwnerResponse = ownerService.saveOwner(saveOwnerRequest);
    return new ResponseEntity<>(saveOwnerResponse, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<GetOwnerResponse> getOwner(@RequestParam String id){
    GetOwnerResponse getOwnerResponse = ownerService.getOwner(id);
    return new ResponseEntity<>(getOwnerResponse, HttpStatus.OK);
  }
}
