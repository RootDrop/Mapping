package com.mapping.demo.onetomany.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "blog")
public class Blog {

  @Id
  @Column(name = "id")
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "category")
  private String category;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "owner_id")
  private Owner owner;
}
