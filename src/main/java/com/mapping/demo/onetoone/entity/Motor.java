package com.mapping.demo.onetoone.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "motor_cycle")
public class Motor {

  @Id
  @Column(name = "id")
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @Column(name = "gear_box")
  private String gearBox;

  @Column(name = "height")
  private Long height;

  @Column(name = "weight")
  private Long weight;

  @Column(name = "manufacturer_name")
  private String manufacturerName;

  @Column(name = "model_name")
  private String modelName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "engine_id")
  private Engine engine;
}
