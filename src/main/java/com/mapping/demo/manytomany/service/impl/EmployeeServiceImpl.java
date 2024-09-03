package com.mapping.demo.manytomany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mapping.demo.manytomany.entity.Employee;
import com.mapping.demo.manytomany.entity.Project;
import com.mapping.demo.manytomany.repository.EmployeeRepository;
import com.mapping.demo.manytomany.request.SaveEmployeeRequest;
import com.mapping.demo.manytomany.response.GetEmployeeResponse;
import com.mapping.demo.manytomany.response.SaveEmployeeResponse;
import com.mapping.demo.manytomany.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Override
  public SaveEmployeeResponse saveEmployee(SaveEmployeeRequest saveEmployeeRequest) {

    Employee employee = Employee.builder()
        .name(saveEmployeeRequest.getName())
        .email(saveEmployeeRequest.getEmail())
        .technicalSkills(saveEmployeeRequest.getTechnicalSkills())
        .build();

    List<Project> projectList = new ArrayList<>();

    saveEmployeeRequest.getProjects().forEach(project -> {
      Project projects = Project.builder()
          .projectName(project.getProjectName())
          .technologyUsed(project.getTechUsed())
          .build();

      projectList.add(projects);
    });

    employee.setProjects(projectList);

    employeeRepository.save(employee);

    SaveEmployeeResponse saveEmployeeResponse = new SaveEmployeeResponse();

    saveEmployeeResponse.setMessage("Employee saved successfully");
    saveEmployeeResponse.setSuccess(1);

    return saveEmployeeResponse;
  }

  @Override
  public GetEmployeeResponse getEmployee(String id) {

    GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

    if (id.isEmpty()) {
      List<Employee> employeeList = employeeRepository.findAll();

      List<GetEmployeeResponse.EmployeesInfo> employeesInfoList = new ArrayList<>();

      employeeList.forEach(employee -> {
        GetEmployeeResponse.EmployeesInfo employeesInfoResponse = new GetEmployeeResponse.EmployeesInfo();

        employeesInfoResponse.setId(employee.getId());
        employeesInfoResponse.setName(employee.getName());
        employeesInfoResponse.setEmail(employee.getEmail());
        employeesInfoResponse.setTechnicalSkills(employee.getTechnicalSkills());

        List<GetEmployeeResponse.EmployeesInfo.ProjectInfo> projectInfosList = new ArrayList<>();

        employee.getProjects().forEach(project -> {
          GetEmployeeResponse.EmployeesInfo.ProjectInfo projectInfoResponse = new GetEmployeeResponse.EmployeesInfo.ProjectInfo();
          projectInfoResponse.setId(project.getId());
          projectInfoResponse.setProjectName(project.getProjectName());
          projectInfoResponse.setTechnologyUsed(project.getTechnologyUsed());

          projectInfosList.add(projectInfoResponse);
        });

        employeesInfoResponse.setProjectInfo(projectInfosList);

        employeesInfoList.add(employeesInfoResponse);
      });

      getEmployeeResponse.setEmployees(employeesInfoList);

    } else {
      Employee employee = employeeRepository.findById(id).get();

      GetEmployeeResponse.EmployeesInfo employeesInfoResponse = new GetEmployeeResponse.EmployeesInfo();

      employeesInfoResponse.setId(employee.getId());
      employeesInfoResponse.setName(employee.getName());
      employeesInfoResponse.setEmail(employee.getEmail());
      employeesInfoResponse.setTechnicalSkills(employee.getTechnicalSkills());

      List<GetEmployeeResponse.EmployeesInfo.ProjectInfo> projectInfosList = new ArrayList<>();
      employee.getProjects().forEach(project -> {
        GetEmployeeResponse.EmployeesInfo.ProjectInfo projectInfoResponse = new GetEmployeeResponse.EmployeesInfo.ProjectInfo();

        projectInfoResponse.setId(project.getId());
        projectInfoResponse.setProjectName(project.getProjectName());
        projectInfoResponse.setTechnologyUsed(project.getTechnologyUsed());

        projectInfosList.add(projectInfoResponse);
      });

      employeesInfoResponse.setProjectInfo(projectInfosList);

      getEmployeeResponse.setEmployee(employeesInfoResponse);
    }

    getEmployeeResponse.setSuccess(1);
    getEmployeeResponse.setMessage("success");

    return getEmployeeResponse;
  }
}
