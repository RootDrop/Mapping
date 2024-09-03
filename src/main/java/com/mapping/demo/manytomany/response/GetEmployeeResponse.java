package com.mapping.demo.manytomany.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetEmployeeResponse {

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;

  @JsonProperty("employees")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<EmployeesInfo> employees;

  @JsonProperty("employee")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private EmployeesInfo employee;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class EmployeesInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("technical_skills")
    private String technicalSkills;

    @JsonProperty("project")
    private List<ProjectInfo> projectInfo;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ProjectInfo {
      @JsonProperty("id")
      private String id;

      @JsonProperty("project_name")
      private String projectName;

      @JsonProperty("technology_used")
      private String technologyUsed;
    }
  }
}
