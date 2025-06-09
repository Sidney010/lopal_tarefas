package br.dev.sidney.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

import br.dev.sidney.tarefas.dao.FuncionarioDAO;
import br.dev.sidney.tarefas.model.Funcionario;
import br.dev.sidney.tarefas.ui.FrameFuncionario;
import br.dev.sidney.tarefas.ui.FrameFuncionarioList;
import br.dev.sidney.tarefas.ui.FrameGerenciadorTarefas;
import br.dev.sidney.tarefas.ui.FrameTarefas;
import br.dev.sidney.tarefas.utils.Utils;

public class Main {

	private static String path = "c:\\Users\\25132876\\ProjetoTarefasDS1TB\\tarefas.txt";

	public static void main(String[] args) {
		
		new FrameGerenciadorTarefas();
		
//		List<String> frutas = new ArrayList<String>();
//		frutas.add("Banana");
//		frutas.add("Melancia");
//		frutas.add("Maçã");
//		frutas.add("Uva");
//		frutas.add("Ameixa");
//		frutas.add("Melão");
//		
//		System.out.println(frutas);
		
//		new FrameFuncionario();
//		
//		FuncionarioDAO dao = new FuncionarioDAO();
//		List<Funcionario> funcionarios = dao.listar();
//		for (Funcionario f : funcionarios) {
//			System.out.println(f.getNome());
//			System.out.println(f.getCargo());
//			System.out.println("---------");
//		}
		
//		Funcionario f = new Funcionario();
//		f.setNome("Priscila Duartes");
//		f.setCargo("Gerentes de Contas");
//		f.setSalario(11784.67);
//		System.out.println();
//		
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f);
//		dao.gravar();
	}

//	private static void gravarArquivo() {
//		FileWriter fw = null;
//		BufferedWriter bw = null;
//		try {
//			fw = new FileWriter(path, true);
//			bw = new BufferedWriter(fw);
//
//			String novaLinha = "Isso é uma nova linha!\n";
//			String novaLinha1 = "Senai Jandira\n";
//			String novaLinha2 = "Turma DS1TB\n";
//
//			bw.write(novaLinha);
//			bw.write(novaLinha1);
//			bw.write(novaLinha2);
//			bw.flush();
//
//		} catch (Exception erro) {
//
//			System.out.println(erro.getMessage());
//		}
//
//	}
//
//	private static void lerArquivo() {
//		FileReader fr = null;
//		BufferedReader br = null;
//
//		try {
//			fr = new FileReader(path);
//			br = new BufferedReader(fr);
//
//			String linha = br.readLine();
//			while (linha != null) {
//				String registro[] = linha.split(";");
//				System.out.println(" Nome:    " + registro[0]);
//				System.out.println(" Tarefa:  " + registro[1]);
//				System.out.println(" Data início:  " + registro[2]);
//				System.out.println(" Prazo:  " + registro[3]);
//				System.out.println(" Entrega:  " + registro[4]);
//				System.out.println(" Status:  " + registro[5]);
//				System.out.println();
//
//				linha = br.readLine();
//			}
//
//		} catch (FileNotFoundException erro) {
//			System.out.println(erro.getMessage());
//
//		} catch (IOException erro) {
//			System.out.println(erro.getMessage());
//
//		} catch (Exception erro) {
//			System.out.println(erro.getMessage());
//
//		}
//	}

}
