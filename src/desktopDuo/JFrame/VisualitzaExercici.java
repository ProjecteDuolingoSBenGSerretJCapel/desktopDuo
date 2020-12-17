package desktopDuo.JFrame;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Scrollbar;

public class VisualitzaExercici {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualitzaExercici window = new VisualitzaExercici();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualitzaExercici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 580, 460);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension (460,45*20));
		panel.setLayout(null);
		scrollPane.setViewportView(panel);
			
		creadorBotons(panel);
		
		
	}
	public void creadorBotons(JPanel panel) {
		int sum=0;
		ArrayList<JButton> botons= new ArrayList <JButton>();
		
		
		
		for(int x=0; x<20;x++) {
			String enunciat=("Enunciat exercici "+(x+1)+" ");
			String tipus="Tipus";
			JButton btnNewButton = new JButton(enunciat+tipus);
			
			btnNewButton.setBounds(0 , sum,600, 45);
			sum+=45;
			botons.add(btnNewButton);
		}
		for (JButton jBotons : botons) {
			panel.add(jBotons);
		}
	}
}
