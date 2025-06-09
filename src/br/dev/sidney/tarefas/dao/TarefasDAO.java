package br.dev.sidney.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.sidney.tarefas.factory.FileFactory;
import br.dev.sidney.tarefas.model.Tarefas;

public class TarefasDAO {
	
	private Tarefas tarefas;

	public TarefasDAO() {

	}

	public TarefasDAO(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(tarefas.toString());
			ff.getBufferedWriter().flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Tarefas> listar() {

		List<Tarefas> Tarefas = new ArrayList<Tarefas>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br2 = ff.getBufferedReader();

			String linha = "";

			br2.readLine();

			while (linha != null) {
				// Extraído uma linha do arquivo
				linha = br2.readLine();

				// Cria um vetor
				if (linha != null) {
					String tarefasStr[] = linha.split(",");

					// Criando um objeto funcionario
					Tarefas tarefas = new Tarefas();
					tarefas.setCodigo(tarefasStr[0]);
					tarefas.setTitulo(tarefasStr[1]);
					tarefas.setDescricao(tarefasStr[2]);
					tarefas.setDataInc(tarefasStr[3]);
//					tarefas.setPrazo(tarefasStr[4]);
//					tarefas.setDataConclusao(tarefasStr[5]);
//					tarefas.setStatus(tarefasStr[6]));
//					tarefas.setFuncionario(tarefasStr[7]));


					Tarefas.add(tarefas);

				}

			}

			return Tarefas;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
