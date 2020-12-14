package Activitats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import libDuo.model.Curs;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ATrLliure {

	private static JFrame frame;
	private static JTextField tFRespostas;
	private static JTextField tFFraseOrigen;
	private static ArrayList<String> llistaRespostesC = new ArrayList<String>();
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATrLliure window = new ATrLliure();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public ATrLliure() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 204, 501, 223);
		panel.add(scrollPane);
		
		JList listRespostes = new JList();
		scrollPane.setViewportView(listRespostes);
		
		JLabel lblAfegirTradLliure = new JLabel("Afegeix una resposta correcta");
		lblAfegirTradLliure.setBounds(29, 83, 269, 20);
		panel.add(lblAfegirTradLliure);
		
		tFRespostas = new JTextField();
		tFRespostas.setBounds(29, 114, 501, 20);
		panel.add(tFRespostas);
		tFRespostas.setColumns(10);
		
		JButton btnGuardarEx = new JButton("Guardar exercici");
		btnGuardarEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (llistaRespostesC.isEmpty() && tFFraseOrigen.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "No hi ha frase a traduir ni cap resposta correcta");
				}else if(tFFraseOrigen.getText().equals("")){
					JOptionPane.showMessageDialog(frame, "No hi ha frase a traduir");
					
				}else if(llistaRespostesC.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No hi ha cap resposta correcta");
				}else {
					
					
					
					frame.dispose();
				}
				
			}
		});
		btnGuardarEx.setBounds(29, 438, 501, 62);
		panel.add(btnGuardarEx);
		DefaultListModel defaultListModel = new DefaultListModel<>();
		listRespostes.setModel(defaultListModel);
		JButton btnAfLlista = new JButton("Afegir resposta correcta");
		btnAfLlista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respostaTemp = tFRespostas.getText();
				System.out.print(respostaTemp);
				llistaRespostesC.add(respostaTemp);
				defaultListModel.addElement(respostaTemp);
			}
		});
		btnAfLlista.setBounds(29, 145, 501, 23);
		panel.add(btnAfLlista);
		
		
		JLabel lblTitolLlista = new JLabel("Respostes correctas");
		lblTitolLlista.setBounds(29, 179, 171, 14);
		panel.add(lblTitolLlista);
		
		JLabel lblFraseOrigen = new JLabel("Introdueix frase original");
		lblFraseOrigen.setBounds(29, 11, 184, 14);
		panel.add(lblFraseOrigen);
		
		tFFraseOrigen = new JTextField();
		tFFraseOrigen.setBounds(29, 50, 501, 20);
		panel.add(tFFraseOrigen);
		tFFraseOrigen.setColumns(10);
		frame.setVisible(true);
	}
}
