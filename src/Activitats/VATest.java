package Activitats;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VATest {

	private static JFrame frame;
	private static JButton btnResposta1;
	private static JButton btnResposta2;
	private static JButton btnResposta3;
	private static JLabel lblPregunta;
	private static String respostaCorrecte;
	
	/**
	 * Create the application.
	 */
	public VATest() {
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
		
		btnResposta1 = new JButton("New button");
		btnResposta1.setBounds(20, 229, 153, 55);
		panel.add(btnResposta1);
		
		btnResposta1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(btnResposta1.getText().toString().equalsIgnoreCase(respostaCorrecte)) {
					JOptionPane.showMessageDialog(null, "Correcte", "Correcte", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrecte", "Incorrecte", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnResposta2 = new JButton("New button");
		btnResposta2.setBounds(216, 229, 153, 55);
		panel.add(btnResposta2);
		
		btnResposta2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(btnResposta2.getText().toString().equalsIgnoreCase(respostaCorrecte)) {
					JOptionPane.showMessageDialog(null, "Correcte", "Correcte", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrecte", "Incorrecte", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnResposta3 = new JButton("New button");
		btnResposta3.setBounds(407, 229, 153, 55);
		panel.add(btnResposta3);
		
		btnResposta3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(btnResposta3.getText().toString().equalsIgnoreCase(respostaCorrecte)) {
					JOptionPane.showMessageDialog(null, "Correcte", "Correcte", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrecte", "Incorrecte", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		lblPregunta = new JLabel("New label");
		lblPregunta.setBounds(51, 84, 498, 55);
		panel.add(lblPregunta);
		
		frame.setVisible(true);
	}
	
	public static void setBtResposta1(String resposta1) {
		btnResposta1.setText(resposta1);
	}
	
	public static void setBtResposta2(String resposta2) {
		btnResposta2.setText(resposta2);
	}
	
	public static void setBtResposta3(String resposta3) {
		btnResposta3.setText(resposta3);
	}
	
	public static void setLblEnunciat(String enunciat) {
		lblPregunta.setText(enunciat);
	}
	
	public static void setRespostaCorrecte(String respostaCorrectaJson) {
		respostaCorrecte = respostaCorrectaJson;
	}
}
