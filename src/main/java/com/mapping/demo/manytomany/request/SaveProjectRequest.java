package com.mapping.demo.manytomany.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveProjectRequest {

  @JsonProperty("project_name")
  private String projectName;

  @JsonProperty("tech_used")
  private String techUsed;

  @JsonProperty("employees")
  private List<Employees> employees;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Employees {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("technical_skills")
    private String technicalSkills;
  }
}
