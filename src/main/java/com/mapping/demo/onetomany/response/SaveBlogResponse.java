package com.mapping.demo.onetomany.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveBlogResponse {

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

  @JsonProperty("category")
  private String category;

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;

}
