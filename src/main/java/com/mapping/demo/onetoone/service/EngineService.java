package com.mapping.demo.onetoone.service;

import com.mapping.demo.onetoone.request.SaveEngineRequest;
import com.mapping.demo.onetoone.response.GetEngineResponse;
import com.mapping.demo.onetoone.response.SaveEngineResponse;

public interface EngineService {
  SaveEngineResponse saveEngine(SaveEngineRequest saveEngineRequest);
  GetEngineResponse getEngine(String id);
}
