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
public class GetOwnerResponse {

  @JsonProperty("owner")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private SingleOwner owner;

  @JsonProperty("owners")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<MultiOwner> owners;

  @JsonProperty("message")
  private String message;

  @JsonProperty("success")
  private Integer success;

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

    @JsonProperty("blogs")
    private List<Blog> blogs;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Blog {

      @JsonProperty("id")
      private String id;

      @JsonProperty("title")
      private String title;

      @JsonProperty("content")
      private String content;

      @JsonProperty("category")
      private String category;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class SingleOwner {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("blogs")
    private List<Blog> blogs;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Blog {

      @JsonProperty("id")
      private String id;

      @JsonProperty("title")
      private String title;

      @JsonProperty("content")
      private String content;

      @JsonProperty("category")
      private String category;
    }
  }
}
