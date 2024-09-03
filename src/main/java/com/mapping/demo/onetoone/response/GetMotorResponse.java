package com.mapping.demo.onetoone.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapping.demo.onetoone.entity.Motor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetMotorResponse {

  @JsonProperty("success")
  private Integer success;

  @JsonProperty("message")
  private String message;

  @JsonProperty("motors")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<Motor> motors;

  @JsonProperty("motor")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Motor motor;
}
