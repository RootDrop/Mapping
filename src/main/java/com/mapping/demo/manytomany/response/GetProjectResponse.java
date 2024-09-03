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
public class GetProjectResponse {

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;

  @JsonProperty("project")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private ProjectInfo projectInfo;

  @JsonProperty("projects")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<ProjectInfo> projectInfoList;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class ProjectInfo{
    @JsonProperty("id")
    private String id;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("technology_used")
    private String technologyUsed;

    @JsonProperty("employee")
    private List<EmployeeInfo> employeeInfo;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class EmployeeInfo{

      @JsonProperty("id")
      private String id;

      @JsonProperty("name")
      private String name;

      @JsonProperty("email")
      private String email;

      @JsonProperty("technical_skills")
      private String technicalSkills;
    }
  }
}
