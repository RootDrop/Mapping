package com.mapping.demo.manytomany.service;

import com.mapping.demo.manytomany.request.SaveProjectRequest;
import com.mapping.demo.manytomany.response.GetProjectResponse;
import com.mapping.demo.manytomany.response.SaveProjectResponse;

public interface ProjectService {
  SaveProjectResponse saveProject(SaveProjectRequest saveProjectRequest);

  GetProjectResponse getProject(String id);
}
