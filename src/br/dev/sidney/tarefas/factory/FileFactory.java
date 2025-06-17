package br.dev.sidney.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	//Pasta para acessar no senai
	private String arquivo = "C:\\Users\\25132876\\ProjetoTarefasDS1TB\\funcionarios.csv";
	private String arquivo2 = "C:\\Users\\25132876\\ProjetoTarefasDS1TB\\tarefas.csv";
	
	//Pasta para acessar em minha casa
//	private String arquivo = "C:\\Users\\araso\\ProjetoTarefasDS1TB\\funcionarios.csv";
//	private String arquivo2 = "C:\\Users\\araso\\ProjetoTarefasDS1TB\\tarefas.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw2;
	private BufferedWriter bw2;
	private FileReader fr2;
	private BufferedReader br2;

	public FileFactory() throws IOException {
		
	
		//Necessário para escrever no arquivo
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
		
		//Necessário pra ler no arquivo
		fr = new FileReader(arquivo);
		br = new BufferedReader(fr);
		
		fw2 = new FileWriter(arquivo2, true);
		bw2 = new BufferedWriter(fw2);
		
		//Necessário pra ler no arquivo
		fr2 = new FileReader(arquivo2);
		br2 = new BufferedReader(fr2);
	}
	
	public BufferedWriter getBufferedWriter(){
		return bw;
	}
	
	public BufferedReader getBufferedReader() {
		return br;
	}
	public BufferedWriter getBufferedWriter2(){
		return bw2;
	}
	
	public BufferedReader getBufferedReader2() {
		return br2;
	}
	
}
