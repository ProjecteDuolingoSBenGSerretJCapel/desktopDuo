package Activitats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VATest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VATest window = new VATest();
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
	public VATest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnResposta1 = new JButton("New button");
		btnResposta1.setBounds(20, 229, 153, 55);
		panel.add(btnResposta1);
		
		JButton btnResposta2 = new JButton("New button");
		btnResposta2.setBounds(216, 229, 153, 55);
		panel.add(btnResposta2);
		
		JButton btnResposta3 = new JButton("New button");
		btnResposta3.setBounds(407, 229, 153, 55);
		panel.add(btnResposta3);
		
		JLabel lblPregunta = new JLabel("New label");
		lblPregunta.setBounds(51, 84, 498, 55);
		panel.add(lblPregunta);
	}
}
