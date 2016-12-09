package com.anhanguera.entity;

public class PessoaEntity {
	
	//atributo
	private int idPessoa;
	private String nome;
	private int idade;
	
	//construtores
	
	//metodos
	public int getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(int idPessoa){
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}	
}
