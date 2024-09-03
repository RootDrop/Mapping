package com.mapping.demo.manytomany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mapping.demo.manytomany.entity.Employee;
import com.mapping.demo.manytomany.entity.Project;
import com.mapping.demo.manytomany.repository.ProjectRepository;
import com.mapping.demo.manytomany.request.SaveProjectRequest;
import com.mapping.demo.manytomany.response.GetProjectResponse;
import com.mapping.demo.manytomany.response.SaveProjectResponse;
import com.mapping.demo.manytomany.service.ProjectService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private ProjectRepository projectRepository;

  @Override
  public SaveProjectResponse saveProject(SaveProjectRequest saveProjectRequest) {

    Project project = Project.builder()
        .projectName(saveProjectRequest.getProjectName())
        .technologyUsed(saveProjectRequest.getTechUsed())
        .build();

    List<Employee> employeeList = new ArrayList<>();

    saveProjectRequest.getEmployees().forEach(employees -> {
      Employee emp = Employee.builder()
          .name(employees.getName())
          .email(employees.getEmail())
          .technicalSkills(employees.getTechnicalSkills())
          .build();

      employeeList.add(emp);
    });
    project.setEmployees(employeeList);

    projectRepository.save(project);

    SaveProjectResponse saveProjectResponse = new SaveProjectResponse();

    saveProjectResponse.setMessage("Project saved successfully");
    saveProjectResponse.setSuccess(1);

    return saveProjectResponse;
  }

  @Override
  public GetProjectResponse getProject(String id) {

    GetProjectResponse getProjectResponse = new GetProjectResponse();

    if (id.isEmpty()) {
      List<Project> projectList = projectRepository.findAll();

      List<GetProjectResponse.ProjectInfo> projectInfos = new ArrayList<>();
      projectList.forEach(project -> {
        GetProjectResponse.ProjectInfo projectInfoResponse = new GetProjectResponse.ProjectInfo();
        projectInfoResponse.setId(project.getId());
        projectInfoResponse.setProjectName(project.getProjectName());
        projectInfoResponse.setTechnologyUsed(project.getTechnologyUsed());

        List<GetProjectResponse.ProjectInfo.EmployeeInfo> employeeInfos = new ArrayList<>();
        project.getEmployees().forEach(employee -> {
          GetProjectResponse.ProjectInfo.EmployeeInfo employeeInfoResponse = new GetProjectResponse.ProjectInfo.EmployeeInfo();
          employeeInfoResponse.setId(employee.getId());
          employeeInfoResponse.setName(employee.getName());
          employeeInfoResponse.setEmail(employee.getEmail());
          employeeInfoResponse.setTechnicalSkills(employee.getTechnicalSkills());

          employeeInfos.add(employeeInfoResponse);
        });

        projectInfoResponse.setEmployeeInfo(employeeInfos);

        projectInfos.add(projectInfoResponse);
      });
      getProjectResponse.setProjectInfoList(projectInfos);
    } else {
      Project project = projectRepository.findById(id).get();

      GetProjectResponse.ProjectInfo projectInfoResponse = new GetProjectResponse.ProjectInfo();

      projectInfoResponse.setId(project.getId());
      projectInfoResponse.setProjectName(project.getProjectName());
      projectInfoResponse.setTechnologyUsed(project.getTechnologyUsed());

      List<GetProjectResponse.ProjectInfo.EmployeeInfo> employeeInfos = new ArrayList<>();
      project.getEmployees().forEach(employee ->{
        GetProjectResponse.ProjectInfo.EmployeeInfo employeeInfoResponse = new GetProjectResponse.ProjectInfo.EmployeeInfo();

        employeeInfoResponse.setId(employee.getId());
        employeeInfoResponse.setName(employee.getName());
        employeeInfoResponse.setEmail(employee.getEmail());
        employeeInfoResponse.setTechnicalSkills(employee.getTechnicalSkills());

        employeeInfos.add(employeeInfoResponse);
      });

      projectInfoResponse.setEmployeeInfo(employeeInfos);

      getProjectResponse.setProjectInfo(projectInfoResponse);
    }

    getProjectResponse.setSuccess(1);
    getProjectResponse.setMessage("Success");

    return getProjectResponse;
  }
}
