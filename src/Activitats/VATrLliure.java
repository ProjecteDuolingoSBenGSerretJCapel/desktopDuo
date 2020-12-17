package Activitats;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VATrLliure {

	private static JFrame frame;
	private static JTextField tFresposta;
	private static JButton btnComprobar;
	private static JLabel lblEnunciat;
	private static String respostaCorrecte;
	

	/**
	 * Create the application.
	 */
	public VATrLliure() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblEnunciat = new JLabel("New label");
		lblEnunciat.setBounds(10, 11, 565, 69);
		panel.add(lblEnunciat);
		
		tFresposta = new JTextField();
		tFresposta.setBounds(10, 97, 565, 220);
		panel.add(tFresposta);
		tFresposta.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(10, 327, 564, 23);
		panel.add(btnComprobar);
		
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String resposta = tFresposta.getText().toString();
				resposta = resposta.replace(" ", "").replace(",", "").replace(";", "").replace(":", "").replace(",", "").replace("!", "")
                        .replace("'", "").replace("·", "").replace("$", "").replace("%", "").replace("&", "").replace("/", "")
                        .replace("(", "").replace(")", "").replace("=", "").replace("?", "").replace("¿", "").replace("¡", "");
				
				if(resposta.equalsIgnoreCase(respostaCorrecte)) {
					JOptionPane.showMessageDialog(null, "Correcte", "Correcte", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrecte", "Incorrecte", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		frame.setVisible(true);
	}
	
	public static void setEnunciat(String enunciat) {
		lblEnunciat.setText(enunciat);
	}
	
	public static void setRespostaCorrecte(String correcte) {
		respostaCorrecte = correcte;
	}
	
	
}
