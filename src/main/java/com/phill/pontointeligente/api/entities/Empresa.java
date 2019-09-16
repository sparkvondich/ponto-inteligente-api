package com.phill.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="Empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 2584422046715317894L;

	private Long id;
	private String razasocial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionarios;
	
	public Empresa() {
		
	}
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "razao_social", nullable=false)
	public String getRazasocial() {
		return razasocial;
	}

	public void setRazasocial(String razasocial) {
		this.razasocial = razasocial;
	}
	@Column(name = "cnpj", nullable=false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@Column(name = "data_criacao", nullable=false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Column(name = "data_atualizacao", nullable=false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
    @OneToMany(mappedBy ="empresa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao= new Date();
	}
	@PrePersist
	public void prePersist() {
	final Date atual = new Date();
	dataCriacao=atual;
	dataAtualizacao=atual;
		
	}
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razasocial=" + razasocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
}
