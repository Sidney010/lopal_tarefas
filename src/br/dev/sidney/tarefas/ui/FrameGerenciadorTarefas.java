package br.dev.sidney.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameGerenciadorTarefas {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public FrameGerenciadorTarefas() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setSize(400, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Gerenciador de Tarefas");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(50, 50, 120, 40);
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(220, 50, 120, 40);
		

		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			new FrameFuncionarioList();
	
				
			}
		});
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameGerenTarefasList();
				
			}
		});
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		tela.setVisible(true);
		
	}



	

}
