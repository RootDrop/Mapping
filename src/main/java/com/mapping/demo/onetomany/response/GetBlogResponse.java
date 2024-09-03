package com.mapping.demo.onetomany.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetBlogResponse {

  @JsonProperty("blog")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private SingleBlog blog;

  @JsonProperty("blogs")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<MultiBlog> blogs;

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class MultiBlog{
    @JsonProperty("id")
    private String id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("category")
    private String category;

    @JsonProperty("owner")
    private MultiOwner owner;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MultiOwner{
      @JsonProperty("id")
      private String id;

      @JsonProperty("name")
      private String name;

      @JsonProperty("email")
      private String email;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class SingleBlog{

    @JsonProperty("id")
    private String id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("category")
    private String category;

    @JsonProperty("owner")
    private SingleOwner owner;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SingleOwner{

      @JsonProperty("id")
      private String id;

      @JsonProperty("name")
      private String name;

      @JsonProperty("email")
      private String email;
    }
  }
}
