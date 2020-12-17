package desktopDuo.JFrame;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import libDuo.Dao.IExercicisDAO;
import libDuo.Dao.INivellsDAO;
import libDuo.implement.ExercicisImpl;
import libDuo.implement.NivellsImpl;
import libDuo.model.Exercicis;
import libDuo.model.Nivells;

import javax.swing.JButton;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualitzaExercici {

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
			
			
			String enunciat=("Enunciat exercici "+(x+1)+" ");
			String tipus="Tipus";
			JButton btnTemp = new JButton(enunciat+tipus);
			
			btnTemp.setBounds(0 , sum,600, 45);
			
			botons.add(btnTemp);
			sum+=45;
			
		}
		for (JButton jBotons : botons) {
		
			
			jBotons.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			panel.add(jBotons);
		}
		
	}
}
