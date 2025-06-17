package br.dev.sidney.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import br.dev.sidney.tarefas.dao.TarefasDAO;
import br.dev.sidney.tarefas.model.Tarefas;

public class FrameGerenTarefasList {
	private JLabel labelTitulo;
	private JButton btnNovaTarefa;
	private JButton btnSair;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;
	private String[] colunas = {"CÓDIGO", "NOME", "RESPONSAVEL"};
	
	public FrameGerenTarefasList() {
		criarTela();
	}

	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Lista de Tarefas");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		//Criação da Tabela
		modelTarefas = new DefaultTableModel(colunas, 5) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		scrollTarefas= new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 60, 460, 300);
		
		carregarDados();
		
		
		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(10, 380, 100, 40);
		btnSair = new JButton("Sair");
		btnSair.setBounds(120, 380, 100, 40);
		
		btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameTarefas(tela);
				carregarDados();
				
			}
		});
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					tela.dispose();
				
			}
		});
		
		painel.add(btnSair);
		painel.add(scrollTarefas);
		painel.add(btnNovaTarefa);
		
		
		tela.setVisible(true);
	
	}
	
	private void carregarDados(){
		TarefasDAO dao = new TarefasDAO();
		List<Tarefas> tarefas = dao.listar();
		
		Object[][] dados = new Object[tarefas.size()][3];
		
		int i = 0;
		for (Tarefas t : tarefas) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getTitulo();
			dados[i][2] = t.getResponsavel();
			
			i++;
		}
		
		modelTarefas.setDataVector(dados, colunas);
		
		
		
	}
		
		
	}
	



