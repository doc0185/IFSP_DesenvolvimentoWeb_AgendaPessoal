package model;

import java.sql.Date;

public class Tarefas {
	private int id;
	private String titulo;
	private String descricao;
	private Date data_inicio;
	private Date data_conclusao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_conclusao() {
		return data_conclusao;
	}
	public void setData_conclusao(Date data_conclusao) {
		this.data_conclusao = data_conclusao;
	}
	
	

}
