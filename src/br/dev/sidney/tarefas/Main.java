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
		

	}



}
