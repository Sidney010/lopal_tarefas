package br.dev.sidney.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.sidney.tarefas.factory.FileFactory;
import br.dev.sidney.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	public FuncionarioDAO() {

	}

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Funcionario> listar() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReader();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// Extraído uma linha do arquivo
				linha = br.readLine();

				// Cria um vetor
				if (linha != null) {
					String funcioarioStr[] = linha.split(",");

					// Criando um objeto funcionario
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcioarioStr[0]);
					funcionario.setNome(funcioarioStr[1]);
					funcionario.setCargo(funcioarioStr[2]);
					funcionario.setSalario(Double.parseDouble(funcioarioStr[3]));

					funcionarios.add(funcionario);

				}

			}

			return funcionarios;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
