package com.mapping.demo.manytomany.service;

import com.mapping.demo.manytomany.request.SaveEmployeeRequest;
import com.mapping.demo.manytomany.response.GetEmployeeResponse;
import com.mapping.demo.manytomany.response.SaveEmployeeResponse;

public interface EmployeeService {

  SaveEmployeeResponse saveEmployee(SaveEmployeeRequest saveEmployeeRequest);

  GetEmployeeResponse getEmployee(String id);
}
