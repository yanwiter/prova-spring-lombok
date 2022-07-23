package com.ucsbr.com.prova.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ucsbr.com.prova.entity.enumerator.Tipo;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity(name = "perfil")
public class Perfil implements Serializable{
	
	@SuppressWarnings("unused")
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPerfil;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column
	private Tipo tipo;
	
}
