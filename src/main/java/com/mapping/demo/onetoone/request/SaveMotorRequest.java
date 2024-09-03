package com.mapping.demo.onetoone.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveMotorRequest {

  @JsonProperty("gear_box")
  private String gearBox;

  @JsonProperty("height")
  private Long height;

  @JsonProperty("weight")
  private Long weight;

  @JsonProperty("manufacturer_name")
  private String manufacturerName;

  @JsonProperty("model_name")
  private String modelName;

  @JsonProperty("engine")
  private Engine engine;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Engine {

    @JsonProperty("capacity")
    private Long capacity;

    @JsonProperty("engine_type")
    private String engineType;

    @JsonProperty("max_torque")
    private Long maxTorque;
  }
}
