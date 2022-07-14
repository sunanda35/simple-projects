package com.stackroute.capstone.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fav")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class favorite {

  @Id @GeneratedValue
  private Integer id;

  @Column(unique = true)
  private String favBookUrl;
}
