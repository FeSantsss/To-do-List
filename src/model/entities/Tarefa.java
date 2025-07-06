package model.entities;

import java.time.LocalDate;

public class Tarefa {
	private Integer ID = 0;
	private String nomeDaTarefa;
	private String descricao;
	private LocalDate dataDeCriacao;
	private boolean status;
	
	public Tarefa(Integer iD, String nomeDaTarefa, String descricao, LocalDate dataDeCriacao, boolean status) {
		ID = iD;
		this.nomeDaTarefa = nomeDaTarefa;
		this.descricao = descricao;
		this.dataDeCriacao = dataDeCriacao;
		this.status = status;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNomeDaTarefa() {
		return nomeDaTarefa;
	}

	public void setNomeDaTarefa(String nomeDaTarefa) {
		this.nomeDaTarefa = nomeDaTarefa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Tarefa [ID = " 
				+ ID 
				+ ", Tarefa: " 
				+ nomeDaTarefa 
				+ ", Descrição: " 
				+ descricao 
				+ ", Data: " 
				+ dataDeCriacao 
				+ " - Status: " 
				+ (status ? "Concluída" : "Pendente") + "]";
	}
}
