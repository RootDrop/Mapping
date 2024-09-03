package com.mapping.demo.onetomany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mapping.demo.onetomany.entity.Blog;
import com.mapping.demo.onetomany.entity.Owner;
import com.mapping.demo.onetomany.repository.BlogRepository;
import com.mapping.demo.onetomany.repository.OwnerRepository;
import com.mapping.demo.onetomany.request.SaveBlogRequest;
import com.mapping.demo.onetomany.response.GetBlogResponse;
import com.mapping.demo.onetomany.response.SaveBlogResponse;
import com.mapping.demo.onetomany.service.BlogService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

  private BlogRepository blogRepository;
  private OwnerRepository ownerRepository;

  @Override
  public SaveBlogResponse saveBlog(SaveBlogRequest saveBlogRequest) {

    Owner owner = ownerRepository.findById(saveBlogRequest.getUserId()).get();

    Blog blog = Blog.builder()
        .title(saveBlogRequest.getTitle())
        .category(saveBlogRequest.getCategory())
        .content(saveBlogRequest.getContent())
        .owner(owner)
        .build();

    blogRepository.save(blog);

    SaveBlogResponse saveBlogResponse = new SaveBlogResponse();
    saveBlogResponse.setTitle(blog.getTitle());
    saveBlogResponse.setCategory(blog.getCategory());
    saveBlogResponse.setContent(blog.getContent());
    saveBlogResponse.setSuccess(1);
    saveBlogResponse.setMessage("Blog saved successfully");

    return saveBlogResponse;
  }

  @Override
  public GetBlogResponse getBlog(String id) {

    GetBlogResponse getBlogResponse = new GetBlogResponse();

    if (id.isEmpty()) {
      List<Blog> blogList = blogRepository.findAll();

      List<GetBlogResponse.MultiBlog> multiBlogs = new ArrayList<>();

      blogList.forEach(blog -> {
        GetBlogResponse.MultiBlog multiBlogResponse = new GetBlogResponse.MultiBlog();
        multiBlogResponse.setId(blog.getId());
        multiBlogResponse.setCategory(blog.getCategory());
        multiBlogResponse.setContent(blog.getContent());

        Owner owner = ownerRepository.findById(blog.getOwner().getId()).get();
        GetBlogResponse.MultiBlog.MultiOwner multiOwnerResponse = new GetBlogResponse.MultiBlog.MultiOwner();
        multiOwnerResponse.setId(owner.getId());
        multiOwnerResponse.setName(owner.getName());
        multiOwnerResponse.setEmail(owner.getEmail());

        multiBlogResponse.setOwner(multiOwnerResponse);
        multiBlogs.add(multiBlogResponse);
      });

      getBlogResponse.setBlogs(multiBlogs);
    } else {
      Blog blog = blogRepository.findById(id).get();

      GetBlogResponse.SingleBlog singleBlogResponse = new GetBlogResponse.SingleBlog();

      singleBlogResponse.setId(blog.getId());
      singleBlogResponse.setCategory(blog.getCategory());
      singleBlogResponse.setContent(blog.getContent());

      Owner owner = ownerRepository.findById(blog.getOwner().getId()).get();

      GetBlogResponse.SingleBlog.SingleOwner singleOwnerResponse = new GetBlogResponse.SingleBlog.SingleOwner();
      singleOwnerResponse.setId(owner.getId());
      singleOwnerResponse.setName(owner.getName());
      singleOwnerResponse.setEmail(owner.getEmail());

      singleBlogResponse.setOwner(singleOwnerResponse);

      getBlogResponse.setBlog(singleBlogResponse);
    }

    getBlogResponse.setMessage("success");
    getBlogResponse.setSuccess(1);

    return getBlogResponse;
  }
}
