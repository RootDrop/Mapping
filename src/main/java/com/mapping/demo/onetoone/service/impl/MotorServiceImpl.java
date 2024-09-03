package com.mapping.demo.onetoone.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mapping.demo.onetoone.entity.Engine;
import com.mapping.demo.onetoone.entity.Motor;
import com.mapping.demo.onetoone.repository.EngineRepository;
import com.mapping.demo.onetoone.repository.MotorRepository;
import com.mapping.demo.onetoone.request.SaveMotorRequest;
import com.mapping.demo.onetoone.response.GetMotorResponse;
import com.mapping.demo.onetoone.response.SaveMotorResponse;
import com.mapping.demo.onetoone.service.MotorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MotorServiceImpl implements MotorService {

  private MotorRepository motorRepository;

  private EngineRepository engineRepository;

  @Override
  public SaveMotorResponse saveMotor(SaveMotorRequest saveMotorRequest) {

    Engine engine = Engine.builder()
        .capacity(saveMotorRequest.getEngine().getCapacity())
        .engineType(saveMotorRequest.getEngine().getEngineType())
        .maxTorque(saveMotorRequest.getEngine().getMaxTorque())
        .build();

    Motor motor = Motor.builder()
        .gearBox(saveMotorRequest.getGearBox())
        .height(saveMotorRequest.getHeight())
        .weight(saveMotorRequest.getWeight())
        .manufacturerName(saveMotorRequest.getManufacturerName())
        .modelName(saveMotorRequest.getModelName())
        .engine(engine)
        .build();

    engineRepository.save(engine);
    motorRepository.save(motor);

    SaveMotorResponse.Engine saveEngineResponse = new SaveMotorResponse.Engine();
    saveEngineResponse.setId(engine.getId());
    saveEngineResponse.setCapacity(engine.getCapacity());
    saveEngineResponse.setEngineType(engine.getEngineType());
    saveEngineResponse.setMaxTorque(engine.getMaxTorque());

    SaveMotorResponse saveMotorResponse = new SaveMotorResponse();
    saveMotorResponse.setId(motor.getId());
    saveMotorResponse.setGearBox(motor.getGearBox());
    saveMotorResponse.setHeight(motor.getHeight());
    saveMotorResponse.setWeight(motor.getWeight());
    saveMotorResponse.setManufacturerName(motor.getManufacturerName());
    saveMotorResponse.setModelName(motor.getModelName());
    saveMotorResponse.setEngine(saveEngineResponse);

    saveMotorResponse.setMessage("Motor saved successfully");
    saveMotorResponse.setSuccess(1);

    return saveMotorResponse;
  }

  @Override
  public GetMotorResponse getMotor(String id) {

    GetMotorResponse getMotorResponse = new GetMotorResponse();

    if (id.isEmpty()) {
      List<Motor> motorList = motorRepository.findAll();
      getMotorResponse.setMotors(motorList);
    } else {
      Motor motor = motorRepository.findById(id).get();
      getMotorResponse.setMotor(motor);
    }

    getMotorResponse.setMessage("success");
    getMotorResponse.setSuccess(1);

    return getMotorResponse;
  }
}
