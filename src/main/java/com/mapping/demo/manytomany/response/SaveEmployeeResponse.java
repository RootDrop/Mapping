package com.mapping.demo.manytomany.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveEmployeeResponse {

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;
}
