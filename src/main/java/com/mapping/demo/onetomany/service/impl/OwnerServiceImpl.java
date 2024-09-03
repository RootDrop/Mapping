package com.mapping.demo.onetomany.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mapping.demo.onetomany.entity.Blog;
import com.mapping.demo.onetomany.entity.Owner;
import com.mapping.demo.onetomany.repository.OwnerRepository;
import com.mapping.demo.onetomany.request.SaveOwnerRequest;
import com.mapping.demo.onetomany.response.GetOwnerResponse;
import com.mapping.demo.onetomany.response.SaveOwnerResponse;
import com.mapping.demo.onetomany.service.OwnerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {

  private OwnerRepository ownerRepository;

  @Override
  public SaveOwnerResponse saveOwner(SaveOwnerRequest saveOwnerRequest) {

    Owner owner = Owner.builder()
        .name(saveOwnerRequest.getName())
        .email(saveOwnerRequest.getEmail())
        .build();

    List<Blog> blogs = new ArrayList<>();

    saveOwnerRequest.getBlogs().forEach(blog -> {
      Blog newBlogs = Blog.builder()
          .title(blog.getTitle())
          .content(blog.getContent())
          .category(blog.getCategory())
          .owner(owner)
          .build();

      blogs.add(newBlogs);
    });

    owner.setBlogs(blogs);

    ownerRepository.save(owner);

    SaveOwnerResponse saveOwnerResponse = new SaveOwnerResponse();
    saveOwnerResponse.setId(owner.getId());
    saveOwnerResponse.setName(owner.getName());
    saveOwnerResponse.setEmail(owner.getEmail());
    saveOwnerResponse.setSuccess(1);
    saveOwnerResponse.setMessage("Owner is saved successfully");

    return saveOwnerResponse;
  }

  @Override
  public GetOwnerResponse getOwner(String id) {

    GetOwnerResponse getOwnerResponse = new GetOwnerResponse();

    if (id.isEmpty()) {

      List<GetOwnerResponse.MultiOwner> multiOwners = new ArrayList<>();

      List<Owner> ownerList = ownerRepository.findAll();

      ownerList.forEach(owner -> {
        GetOwnerResponse.MultiOwner multiOwnerResponse = new GetOwnerResponse.MultiOwner();

        multiOwnerResponse.setId(owner.getId());
        multiOwnerResponse.setName(owner.getName());
        multiOwnerResponse.setEmail(owner.getEmail());

        List<GetOwnerResponse.MultiOwner.Blog> blogList = new ArrayList<>();

        owner.getBlogs().forEach(blog -> {

          GetOwnerResponse.MultiOwner.Blog blogResponse = new GetOwnerResponse.MultiOwner.Blog();
          blogResponse.setId(blog.getId());
          blogResponse.setTitle(blog.getTitle());
          blogResponse.setCategory(blog.getCategory());
          blogResponse.setContent(blog.getContent());

          blogList.add(blogResponse);
        });

        multiOwnerResponse.setBlogs(blogList);
        multiOwners.add(multiOwnerResponse);
      });

      getOwnerResponse.setOwners(multiOwners);
    } else {
      Owner owner = ownerRepository.findById(id).get();
      GetOwnerResponse.SingleOwner singleOwnerResponse = new GetOwnerResponse.SingleOwner();
      singleOwnerResponse.setId(owner.getId());
      singleOwnerResponse.setName(owner.getName());
      singleOwnerResponse.setEmail(owner.getEmail());

      List<GetOwnerResponse.SingleOwner.Blog> blogList = new ArrayList<>();
      owner.getBlogs().forEach(blog ->{
        GetOwnerResponse.SingleOwner.Blog blogResponse = new GetOwnerResponse.SingleOwner.Blog();
        blogResponse.setId(blog.getId());
        blogResponse.setTitle(blog.getTitle());
        blogResponse.setContent(blog.getContent());
        blogResponse.setCategory(blog.getCategory());

        blogList.add(blogResponse);
      });

      singleOwnerResponse.setBlogs(blogList);

      getOwnerResponse.setOwner(singleOwnerResponse);
    }
    getOwnerResponse.setMessage("success");
    getOwnerResponse.setSuccess(1);

    return getOwnerResponse;
  }
}
