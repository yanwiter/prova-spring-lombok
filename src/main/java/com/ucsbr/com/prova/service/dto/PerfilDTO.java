package com.ucsbr.com.prova.service.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ucsbr.com.prova.entity.enumerator.Tipo;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
public class PerfilDTO implements Serializable {

	@SuppressWarnings("unused")
	private static final Long serialVersionUID = 1L;

	@ApiModelProperty(value = "Código do perfil", example = "1")
	@NotNull
	private long idPerfil;

	@ApiModelProperty(value = "endereço do perfil", example = "av joão cesar")
	private String endereco;

	@ApiModelProperty(value = "bairro do perfil", example = "novo eldorado")
	private String bairro;

	@ApiModelProperty(value = "Tipo do perfil", example = "START")
	@Min(value = 1, message = "É necessário inserir pelo menos um tipo")
	private Tipo tipo;

	public long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
