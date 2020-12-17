package desktopDuo.JFrame;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Activitats.VATest;
import Activitats.VATrLliure;
import libDuo.Dao.IExerciciTest;
import libDuo.Dao.IExerciciTraduccio;
import libDuo.Dao.IExercicisDAO;
import libDuo.Dao.INivellsDAO;
import libDuo.implement.ExerciciTestImpl;
import libDuo.implement.ExercicisImpl;
import libDuo.implement.ExercicisTraduccioImpl;
import libDuo.implement.NivellsImpl;
import libDuo.model.Exercicis;
import libDuo.model.Nivells;

import javax.swing.JButton;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class VisualitzaExercici {

	private static IExercicisDAO icmanagerEx= new ExercicisImpl();
	private static IExerciciTest icmanagerTest = new ExerciciTestImpl();
	private static IExerciciTraduccio icmanagerTraduccio = new ExercicisTraduccioImpl();
	
	private static ArrayList<String> arrayListJson = new ArrayList<String>();
	private static String jsonString = null;
	
	private static String path = null;
	private static File file = null;
	
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	static void initialize(Nivells nivell) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		arrayListJson.clear();
		
		frame.getContentPane().setLayout(null);
		
		IExercicisDAO iCManagerExercici = new ExercicisImpl();
		
		ArrayList <Exercicis> llistaExercicis= (ArrayList<Exercicis>) iCManagerExercici.getAllExercicisByNivell(nivell);  
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 580, 460);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension (460,45*llistaExercicis.size()));
		panel.setLayout(null);
		scrollPane.setViewportView(panel);
		creadorBotons(panel, llistaExercicis);
		
		
		frame.setVisible(true);
	}
	public static void creadorBotons(JPanel panel, ArrayList<Exercicis> llistaExercicis) {
		int sum=0;
		ArrayList<JButton> botons= new ArrayList <JButton>();
		
		
		
		for(int x=0; x<llistaExercicis.size();x++) {
			String enunciat = null;
			if(x == 0) {
				llegirDadesTest(llistaExercicis);
				enunciat=(arrayListJson.get(1) + "-Tipus:("+arrayListJson.get(0) +")");
			}
			else if(x == 1) {
				llegirDadesBDTraduccio(llistaExercicis);
				enunciat=(arrayListJson.get(1) + "-Tipus:("+arrayListJson.get(0) +")");
			}
			
			JButton btnTemp = new JButton(enunciat);
			
			btnTemp.setBounds(0 , sum,600, 45);
			
			botons.add(btnTemp);
			sum+=45;
			
		}
		for (JButton jBotons : botons) {
		
			
			jBotons.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					llegirDadesTest(llistaExercicis);
					obriTest();
					
					llegirDadesBDTraduccio(llistaExercicis);
					obriTraduccio();
				}
			});
			panel.add(jBotons);
		}
		
	}

	
	public void escriureJson(String jsonString, String path) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	
	public static void llegirDadesTest(ArrayList<Exercicis> llistaExercicis) {
		
			jsonString = icmanagerEx.getDadesEx(llistaExercicis.get(0));
			
				path = "recursos"+File.separator+"fitcher"+File.separator+"exercicis.json";
				file = new File(path);
				icmanagerTest.escriureFicherJson(file, jsonString);
				try {
					icmanagerTest.llegirJson(file);
					arrayListJson = icmanagerTest.getArrayList();
					
					for (String s : arrayListJson) {
						System.out.println(s);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			

	}
	
	public static void llegirDadesBDTraduccio(ArrayList<Exercicis> llistaExercicis) {
		jsonString = icmanagerEx.getDadesEx(llistaExercicis.get(1));
		
		path = "recursos"+File.separator+"fitcher"+File.separator+"exercicis.json";
		file = new File(path);
		icmanagerTraduccio.escriureFicherJson(file, jsonString);
		try {
			icmanagerTraduccio.llegirJson(file);
			arrayListJson = icmanagerTraduccio.getArrayList();
			
			for (String s : arrayListJson) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}
	
	public static void obriTest() {
		VATest.initialize();
		
		VATest.setLblEnunciat(arrayListJson.get(1));
		VATest.setRespostaCorrecte(arrayListJson.get(2));
		
		VATest.setBtResposta1(arrayListJson.get(4));
		VATest.setBtResposta2(arrayListJson.get(5));
		VATest.setBtResposta3(arrayListJson.get(3));
		
	}
	
	public static void obriTraduccio() {
		VATrLliure.initialize();
		VATrLliure.setEnunciat(arrayListJson.get(1));
		VATrLliure.setRespostaCorrecte(arrayListJson.get(3));
	}

}
