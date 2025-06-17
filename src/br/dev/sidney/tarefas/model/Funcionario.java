package br.dev.sidney.tarefas.model;

import br.dev.sidney.tarefas.utils.Utils;

public class Funcionario {

	private String nome;
	private String matricula;
	private String cargo;
	private double salario;

	// metodo construtor
	public Funcionario(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();

	}

	// Construtor Padrão / Default
	public Funcionario() {
		this.matricula = Utils.gerarUUID8();
	}

	public Funcionario(String cargo, String nome) {
		this.cargo = cargo;
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();

	}

	public Funcionario(String cargo, String nome, String matricula, double salario) {
		this.matricula = Utils.gerarUUID8();
		this.cargo = cargo;
		this.nome = nome;
		this.salario = salario;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {

		String funcionario = matricula + ", " + nome + ", " + cargo + ", " + salario + "\n";
		return funcionario;


	}

}
