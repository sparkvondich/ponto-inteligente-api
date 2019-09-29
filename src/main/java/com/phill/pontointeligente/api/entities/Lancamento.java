package com.phill.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

import com.phill.pontointeligente.api.enums.TipoEnum;



@Entity
@Table(name="lancamento")
public class Lancamento implements Serializable {

private static final long serialVersionUID = 8136010398379449118L;


private	Long id;
private Date data;
private	String descricao;
private	Date dataCriacao;
private	Date dataAtualizacao;
private	TipoEnum tipo;
private	Funcionario funcionario;





	public Lancamento(){
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="data",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Column(name="descricao",nullable=false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Column(name="data_criacao",nullable=false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Column(name="data_atualizacao",nullable=false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="tipo",nullable=false)
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao  = new Date();
		
	}
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao= atual;
		dataAtualizacao = atual;
	}
	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", data=" + data + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", tipo=" + tipo + ", funcionario=" + funcionario + "]";
	}
	
	
	
}

