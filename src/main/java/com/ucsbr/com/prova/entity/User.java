package com.ucsbr.com.prova.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name = "usuario")
public class User implements Serializable {

  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;

  @Column(nullable = false)
  private String login;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;
}
