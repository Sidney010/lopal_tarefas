package br.dev.sidney.tarefas.model;

import br.dev.sidney.tarefas.utils.Utils;

public class Tarefas {
	private String codigo;
	private String titulo;
	private String descricao;
	private String dataInc;
	private String prazo;
	private String dataConclusao;
//	private String status;
//	private String responsavel;
//	
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getResponsavel() {
//		return responsavel;
//	}
//
//	public void setResponsavel(String responsavel) {
//		this.responsavel = responsavel;
//	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInc() {
		return dataInc;
	}

	public void setDataInc(String dataInc) {
		this.dataInc = dataInc;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	// metodo construtor
	public Tarefas(String codigo) {
		this.codigo = codigo;
		this.codigo = Utils.gerarUUID8();

	}

	// Construtor Padrão / Default
	public Tarefas() {
		this.codigo = Utils.gerarUUID8();
	}

	public Tarefas(String descricao, String titulo) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.codigo = Utils.gerarUUID8();

	}
	


	public Tarefas(String descricao, String titulo, String codigo, String datInc) {
		this.codigo = Utils.gerarUUID8();
		this.descricao = descricao;
		this.titulo = titulo;
		this.dataInc = dataInc;

	}
	
	public Tarefas(String descricao, String titulo, String codigo, String datInc, String prazo) {
		this.codigo = Utils.gerarUUID8();
		this.descricao = descricao;
		this.titulo = titulo;
		this.dataInc = dataInc;
		this.prazo = prazo;

	}
	public Tarefas(String descricao, String titulo, String codigo, String datInc, String prazo, String dataConclusao) {
		this.codigo = Utils.gerarUUID8();
		this.descricao = descricao;
		this.titulo = titulo;
		this.dataInc = dataInc;
		this.prazo = prazo;
		this.dataConclusao = dataConclusao;
		

	}
//	public Tarefas(String descricao, String titulo, String codigo, String datInc, String prazo, String dataConclusao, String Status) {
//		this.codigo = Utils.gerarUUID8();
//		this.descricao = descricao;
//		this.titulo = titulo;
//		this.dataInc = dataInc;
//		this.prazo = prazo;
//		this.dataConclusao = dataConclusao;
//		this.status = status;
//		
//
//	}
//	public Tarefas(String descricao, String titulo, String codigo, String datInc, String prazo, String dataConclusao, String Status, String Responsavel) {
//		this.codigo = Utils.gerarUUID8();
//		this.descricao = descricao;
//		this.titulo = titulo;
//		this.dataInc = dataInc;
//		this.prazo = prazo;
//		this.dataConclusao = dataConclusao;
//		this.status = status;
//		this.responsavel = responsavel;
//		
//
//	}


	@Override
	public String toString() {

		String tarefas = codigo + ", " + titulo + ", " + descricao + ", " + dataInc  + ", " + prazo + ", " + dataConclusao + "\n";
		return tarefas;

	}

}
