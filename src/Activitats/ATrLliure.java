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

import libDuo.Dao.IExerciciTest;
import libDuo.Dao.IExerciciTraduccio;
import libDuo.Dao.IExercicisDAO;
import libDuo.implement.ExerciciTestImpl;
import libDuo.implement.ExercicisImpl;
import libDuo.implement.ExercicisTraduccioImpl;
import libDuo.model.Curs;
import libDuo.model.ExerciciTest;
import libDuo.model.ExerciciTraduccio;
import libDuo.model.Nivells;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ATrLliure {

	private static JFrame frame;
	private static JTextField tFRespostas;
	private static JTextField tFFraseOrigen;
	private static ArrayList<String> llistaRespostesC = new ArrayList<String>();
	
	
	
	public static void initialize(Nivells nivell) {
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
		
		ArrayList<ExerciciTraduccio> arrayExercicis = new ArrayList<ExerciciTraduccio>();
		
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
					
					IExerciciTraduccio icmanagerJson = new ExercicisTraduccioImpl();
					
					String ruta = "recursos"+File.separator+"fitcher"+File.separator+"exercicis.json";
					File fileJson = icmanagerJson.llegirFicherJson(ruta);

					ExerciciTraduccio ex = icmanagerJson.setNouTipus(arrayExercicis, "Traduccio lliure", tFFraseOrigen.getText(), llistaRespostesC );  
					
					String jsonString = icmanagerJson.getJsonString(fileJson, arrayExercicis);
					icmanagerJson.escriureFicherJson(fileJson, jsonString);
					
					
					IExercicisDAO iCManagerExercici = new ExercicisImpl();
					
					iCManagerExercici.setNouExercici(nivell, jsonString);
					
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
