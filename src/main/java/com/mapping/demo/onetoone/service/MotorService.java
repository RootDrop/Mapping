package com.mapping.demo.onetoone.service;

import com.mapping.demo.onetoone.request.SaveMotorRequest;
import com.mapping.demo.onetoone.response.GetMotorResponse;
import com.mapping.demo.onetoone.response.SaveMotorResponse;

public interface MotorService {
  SaveMotorResponse saveMotor(SaveMotorRequest saveMotorRequest);

  GetMotorResponse getMotor(String id);
}
