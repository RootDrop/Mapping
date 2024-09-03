package com.mapping.demo.onetomany.service;

import com.mapping.demo.onetomany.request.SaveOwnerRequest;
import com.mapping.demo.onetomany.response.GetOwnerResponse;
import com.mapping.demo.onetomany.response.SaveOwnerResponse;

public interface OwnerService {
  SaveOwnerResponse saveOwner(SaveOwnerRequest saveOwnerRequest);
  GetOwnerResponse getOwner(String id);
}
