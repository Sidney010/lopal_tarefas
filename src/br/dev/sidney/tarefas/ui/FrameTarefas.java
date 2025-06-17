package br.dev.sidney.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.sidney.tarefas.dao.FuncionarioDAO;
import br.dev.sidney.tarefas.dao.TarefasDAO;
import br.dev.sidney.tarefas.model.Funcionario;
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


		labelPrazo = new JLabel("Prazo (em dias): ");
		labelPrazo.setBounds(10, 205, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 235, 150, 30);
		
		labelDataConclusao = new JLabel("Data conclusão: ");
		labelDataConclusao.setBounds(10, 270, 200, 30);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(10, 300, 150, 30);
		txtDataConclusao.setEditable(false);
		
		labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(10, 335, 200, 30);
        cmbStatus = new JComboBox<Status>(Status.values());
		cmbStatus.setBounds(10, 365, 150, 30);
		
//		Status[] status = Status.values();
//		for(Status estadoTarefa : status) {
//			cmbStatus.addItem(estadoTarefa);
//		}
//		Status statusEscolhido = (Status) cmbStatus.getSelectedItem();
//		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
//		Funcionario funcionarioEscolhido = (Funcionario) cmbResponsavel.getSelectedItem();
//		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionarios = funcionarioDAO.listar();

		
		labelResponsavel = new JLabel("Responsavel: ");
		labelResponsavel.setBounds(10, 400, 200, 30);
		cmbResponsavel = new JComboBox<Funcionario>(funcionarios.toArray(new Funcionario[0]));
		cmbResponsavel.setBounds(10, 430, 300, 30);
		
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
		painel.add(cmbResponsavel);
		painel.add(labelResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);
		

		txtDataInc.addFocusListener(new FocusAdapter() {
		    public void focusLost(FocusEvent e) {
		        atualizarDataConclusao();
		    }
		});
		txtPrazo.addFocusListener(new FocusAdapter() {
		    public void focusLost(FocusEvent e) {
		        atualizarDataConclusao();
		    }
		});
		
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
	            // Pegar status e funcionário selecionado
	            Status statusEscolhido = (Status) cmbStatus.getSelectedItem();
	            Funcionario funcionarioEscolhido = (Funcionario) cmbResponsavel.getSelectedItem();

	            // Ler data inicial e prazo
	            String dataInicialStr = txtDataInc.getText();
	            int prazoDias = Integer.parseInt(txtPrazo.getText());

	            // Converter e somar prazo usando LocalDate
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
	            LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
	            String dataConclusaoStr = dataConclusao.format(formatter);
	            txtDataConclusao.setText(dataConclusaoStr);

		        // Criar a tarefa
		        Tarefas t = new Tarefas(
		            txtTitulo.getText(),
		            txtDescricao.getText(),
		            txtDataInc.getText(),
		            txtPrazo.getText(),
		            txtDataConclusao.getText(),
		            statusEscolhido.name(),
		            funcionarioEscolhido.getNome()
		        );

		        // Gravar no DAO
		        TarefasDAO dao = new TarefasDAO(t);
		        dao.gravar();
		        JOptionPane.showMessageDialog(tela, txtTitulo.getText() + " gravado com sucesso", "Sucesso !!!", JOptionPane.INFORMATION_MESSAGE);
		        limparFormulario();
			}
		});

		tela.setVisible(true);
		
	}
	private void atualizarDataConclusao() {
	    String dataInicialStr = txtDataInc.getText().trim();
	    String prazoStr = txtPrazo.getText().trim();

	    try {
	        if (dataInicialStr.isEmpty() || prazoStr.isEmpty()) return;

	        int prazoDias = Integer.parseInt(prazoStr);

	        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	            .appendValue(ChronoField.DAY_OF_MONTH)
	            .appendLiteral('/')
	            .appendValue(ChronoField.MONTH_OF_YEAR)
	            .appendLiteral('/')
	            .appendValue(ChronoField.YEAR, 4)
	            .toFormatter();

	        LocalDate dataInicial = LocalDate.parse(dataInicialStr, formatter);
	        LocalDate dataConclusao = dataInicial.plusDays(prazoDias);
	        String dataConclusaoStr = dataConclusao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	        txtDataConclusao.setText(dataConclusaoStr);
	    } catch (Exception e) {
	        txtDataConclusao.setText("Data inválida");
	    }
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
