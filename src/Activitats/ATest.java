package Activitats;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import libDuo.Dao.IExercici;
import libDuo.implement.ExerciciImpl;
import libDuo.model.Exercici;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ATest {

	private static JFrame frame;
	private static JTextField tfEnunciat;
	private static JTextField tfR1;
	private static JTextField tfR2;
	private static JTextField tfR3;
	private static JTextField tfRespostaCorrecta;

	
	public static void initialize() {
		
		frame = new JFrame();
		frame.setBounds( 10, 10 ,700, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panell = new JPanel();
		frame.getContentPane().add(panell, BorderLayout.CENTER);
		panell.setLayout(null);

		Toolkit icona = Toolkit.getDefaultToolkit();
		Image logo = icona.getImage("imgs"+File.separator+"Logo.png");
		frame.setIconImage(new ImageIcon (logo).getImage());

		JLabel enunciat = new JLabel("Enunciat:");
		enunciat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enunciat.setBounds(33, 80, 123, 32);
		panell.add(enunciat);

		JLabel lbR1 = new JLabel("Resposta 1:");
		lbR1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbR1.setBounds(33, 159, 132, 32);
		panell.add(lbR1);

		tfEnunciat = new JTextField();
		tfEnunciat.setBounds(198, 88, 448, 20);
		panell.add(tfEnunciat);
		tfEnunciat.setColumns(10);
		
		tfR1 = new JTextField();
		tfR1.setColumns(10);
		tfR1.setBounds(198, 167, 448, 20);
		panell.add(tfR1);
		
		JLabel lbR2 = new JLabel("Resposta 2:");
		lbR2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbR2.setBounds(33, 247, 132, 32);
		panell.add(lbR2);
		
		JLabel lbR3 = new JLabel("Resposta 3:");
		lbR3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbR3.setBounds(33, 338, 132, 32);
		panell.add(lbR3);
		
		JLabel lbRCorrecta = new JLabel("Resposta Correcta:");
		lbRCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbRCorrecta.setBounds(33, 428, 132, 32);
		panell.add(lbRCorrecta);
		
		tfR2 = new JTextField();
		tfR2.setColumns(10);
		tfR2.setBounds(198, 255, 448, 20);
		panell.add(tfR2);
		
		tfR3 = new JTextField();
		tfR3.setColumns(10);
		tfR3.setBounds(198, 346, 448, 20);
		panell.add(tfR3);
		
		tfRespostaCorrecta = new JTextField();
		tfRespostaCorrecta.setColumns(10);
		tfRespostaCorrecta.setBounds(198, 436, 448, 20);
		panell.add(tfRespostaCorrecta);
		ArrayList<Exercici> arrayExercicis = new ArrayList<Exercici>();
		JButton jbGuardar = new JButton("Guardar");
		jbGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				IExercici icmanagerJson = new ExerciciImpl();
				
				String ruta = "recursos"+File.separator+"fitcher"+File.separator+"exercicis.json";
				File fileJson = icmanagerJson.llegirFicherJson(ruta);
				
				Exercici ex = icmanagerJson.setNouTipus(arrayExercicis,"test", tfEnunciat.getText(), tfR1.getText(), tfR2.getText(), tfR3.getText(), tfRespostaCorrecta.getText());
				
				String jsonString = icmanagerJson.getJsonString(fileJson, arrayExercicis);
				icmanagerJson.escriureFicherJson(fileJson, jsonString);
				
//				
//				try {
//					icmanagerJson.llegirJson(fileJson);
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
				
				frame.dispose();
			}
		});
	
		jbGuardar.setBounds(33, 490, 238, 43);
		panell.add(jbGuardar);
		frame.setVisible(true);
		
	}
	
	public String getEnunciat() {
		return tfEnunciat.getText();
	}
	
	public String getR1() {
		return tfR1.getText();
	}
	
	public String getR2() {
		return tfR2.getText();
	}
	
	public String getR3() {
		return tfR3.getText();
	}
	
	public String getRespostaCorrecte() {
		return tfRespostaCorrecta.getText();
	}
}
