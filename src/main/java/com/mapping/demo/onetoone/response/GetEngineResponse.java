package com.mapping.demo.onetoone.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapping.demo.onetoone.entity.Engine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetEngineResponse {

  @JsonProperty("success")
  private int success;

  @JsonProperty("message")
  private String message;

  @JsonProperty("engines")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<Engine> engines;

  @JsonProperty("engine")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Engine engine;
}
