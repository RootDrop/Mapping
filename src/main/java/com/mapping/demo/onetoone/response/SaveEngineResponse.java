package com.mapping.demo.onetoone.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveEngineResponse {

  @JsonProperty("success")
  private int success;

  @JsonProperty("message")
  private String message;

  @JsonProperty("capacity")
  private Long capacity;

  @JsonProperty("engine_type")
  private String engineType;

  @JsonProperty("max_torque")
  private Long maxTorque;

}
