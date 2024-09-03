package com.mapping.demo.manytomany.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveEmployeeRequest {

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("technical_skills")
  private String technicalSkills;

  @JsonProperty("projects")
  private List<Project> projects;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Project {

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("technology_used")
    private String techUsed;
  }
}
