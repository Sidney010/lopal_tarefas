package br.dev.sidney.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.sidney.tarefas.dao.TarefasDAO;
import br.dev.sidney.tarefas.model.Status;
import br.dev.sidney.tarefas.model.Tarefas;


public class FrameTarefas {
	private JLabel labelTitulo;
	private JLabel labelDescricao;
	private JLabel labelDataInc;
	private JLabel labelPrazo;
	private JLabel labelDataConclusao;
	
	
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtDataInc;
	private JTextField txtPrazo;
	private JTextField txtDataConclusao;
	
	private JLabel labelStatus;
	private JLabel labelResponsavel;
	private JComboBox cmbStatus;
	private JComboBox cmbResponsavel;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameTarefas(JFrame frame) {
		criarTela(frame);
	}

	private void criarTela(JFrame frame) {
		JDialog tela = new JDialog(frame, true);
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 800);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(frame);

		Container painel = tela.getContentPane();
		

		labelTitulo = new JLabel("Título: ");
		labelTitulo.setBounds(10, 10, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 40, 150, 30);
		
		labelDescricao = new JLabel("Descrição: ");
		labelDescricao.setBounds(10, 75, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 105, 365, 30);


		labelDataInc = new JLabel("Data Inicial: ");
		labelDataInc.setBounds(10, 140, 200, 30);
		txtDataInc = new JTextField();
		txtDataInc.setBounds(10, 170, 200, 30);


		labelPrazo = new JLabel("Prazo: ");
		labelPrazo.setBounds(10, 205, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 235, 150, 30);
		
		labelDataConclusao = new JLabel("Data conclusão: ");
		labelDataConclusao.setBounds(10, 270, 200, 30);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(10, 300, 150, 30);
		
		labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(10, 335, 200, 30);
		JComboBox<Status> cmbStatus = new JComboBox<>(Status.values());
		cmbStatus.setBounds(10, 365, 150, 30);
		
		Status[] status = Status.values();
		for(Status estadoTarefa : status) {
			cmbStatus.addItem(estadoTarefa);
		}
		Status statusEscolhido = (Status) cmbStatus.getSelectedItem();
		
		labelResponsavel = new JLabel("Responsavel: ");
		labelResponsavel.setBounds(10, 400, 200, 30);
		//labelStatus = new JTextField();
		//labelStatus.setBounds(10, 430, 150, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 495, 120, 50);
		btnSair = new JButton("Sair");
		btnSair.setBounds(140, 495, 80, 50);
		
		painel.add(txtTitulo);
		painel.add(labelTitulo);
		painel.add(txtDescricao);
		painel.add(labelDescricao);
		painel.add(txtDataInc);
		painel.add(labelDataInc);
		painel.add(txtPrazo);
		painel.add(labelPrazo);
		painel.add(txtDataConclusao);
		painel.add(labelDataConclusao);
		painel.add(labelStatus);
		painel.add(cmbStatus);
		painel.add(labelResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);
		

		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(tela, "Você fechou sem querer hahaha! ....", "Fechar", JOptionPane.ERROR_MESSAGE);
				int resposta = JOptionPane.showConfirmDialog(tela, "Você confirma a saída do sistema?");
				if(resposta == 0) {
					tela.dispose();
				}
				
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefas t = new Tarefas(
						txtTitulo.getText(),
						txtDescricao.getText(),
						txtDataInc.getText(),
						txtPrazo.getText(),
						txtDataConclusao.getText(),
						statusEscolhido.name());
				
				TarefasDAO dao = new TarefasDAO(t);
				dao.gravar();
				JOptionPane.showMessageDialog(tela, txtTitulo.getText() + " gravado com sucesso", "Sucesso !!!", JOptionPane.INFORMATION_MESSAGE);				
				limparFormulario();
			}
		});

		tela.setVisible(true);
		
	}
	private void limparFormulario() {
		txtTitulo.setText(null);
		txtDescricao.setText(null);
		txtDataInc.setText(null);
		txtPrazo.setText(null);
		txtDataConclusao.setText(null);
		txtTitulo.requestFocus();
	}
	
}
