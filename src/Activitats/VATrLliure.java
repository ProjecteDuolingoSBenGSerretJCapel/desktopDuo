package Activitats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VATrLliure {

	private JFrame frame;
	private JTextField tFresposta;
	private JButton btnComprobar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VATrLliure window = new VATrLliure();
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
	public VATrLliure() {
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
		
		JLabel lblEnunciat = new JLabel("New label");
		lblEnunciat.setBounds(10, 11, 565, 69);
		panel.add(lblEnunciat);
		
		tFresposta = new JTextField();
		tFresposta.setBounds(10, 97, 565, 220);
		panel.add(tFresposta);
		tFresposta.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(10, 327, 564, 23);
		panel.add(btnComprobar);
	}
}
