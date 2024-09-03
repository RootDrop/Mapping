package com.mapping.demo.onetomany.service;

import com.mapping.demo.onetomany.request.SaveBlogRequest;
import com.mapping.demo.onetomany.response.GetBlogResponse;
import com.mapping.demo.onetomany.response.SaveBlogResponse;

public interface BlogService {
  SaveBlogResponse saveBlog(SaveBlogRequest saveBlogRequest);

  GetBlogResponse getBlog(String id);
}
