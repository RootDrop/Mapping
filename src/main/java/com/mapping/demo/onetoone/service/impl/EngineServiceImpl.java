package com.mapping.demo.onetoone.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mapping.demo.onetoone.entity.Engine;
import com.mapping.demo.onetoone.repository.EngineRepository;
import com.mapping.demo.onetoone.request.SaveEngineRequest;
import com.mapping.demo.onetoone.response.GetEngineResponse;
import com.mapping.demo.onetoone.response.SaveEngineResponse;
import com.mapping.demo.onetoone.service.EngineService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EngineServiceImpl implements EngineService {

  private EngineRepository engineRepository;

  @Override
  public GetEngineResponse getEngine(String id) {

    GetEngineResponse getEngineResponse = new GetEngineResponse();

    if(id.isEmpty()){
      System.out.println("in");
      List<Engine> engineList = engineRepository.findAll();
      getEngineResponse.setEngines(engineList);

    } else {
      Engine engine = engineRepository.findById(id).get();
      getEngineResponse.setEngine(engine);
    }
    getEngineResponse.setSuccess(1);
    getEngineResponse.setMessage("success");

    return getEngineResponse;
  }

  @Override
  public SaveEngineResponse saveEngine(SaveEngineRequest saveEngineRequest) {

    Engine engine = Engine.builder()
        .capacity(saveEngineRequest.getCapacity())
        .engineType(saveEngineRequest.getEngineType())
        .maxTorque(saveEngineRequest.getMaxTorque())
        .build();

    engineRepository.save(engine);

    SaveEngineResponse saveEngineResponse = new SaveEngineResponse();
    saveEngineResponse.setSuccess(1);
    saveEngineResponse.setMessage("Engine saved successfully");
    saveEngineResponse.setCapacity(engine.getCapacity());
    saveEngineResponse.setEngineType(engine.getEngineType());
    saveEngineResponse.setMaxTorque(engine.getMaxTorque());

    return saveEngineResponse;
  }
}
