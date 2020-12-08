package desktopDuo.JFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TestPreguntaTipoTest {
	
	private JFrame frame;
	private JTextField tfEnunciat;
	private JTextField tfR1;
	private JTextField tfR2;
	private JTextField tfR3;
	private JTextField tfRespostaCorrecta;
	

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TestPreguntaTipoTest window = new TestPreguntaTipoTest();
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
		public TestPreguntaTipoTest() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame = new JFrame();
			frame.setBounds( 10, 10 , (int)screenSize.getWidth()-100, (int)screenSize.getHeight()-100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel enunciat = new JLabel("Enunciat:");
			enunciat.setFont(new Font("Tahoma", Font.PLAIN, 15));
			enunciat.setBounds(33, 80, 123, 32);
			panel.add(enunciat);
			
			JLabel lbR1 = new JLabel("Resposta 1:");
			lbR1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbR1.setBounds(33, 159, 132, 32);
			panel.add(lbR1);
			
			tfEnunciat = new JTextField();
			tfEnunciat.setBounds(175, 88, 448, 20);
			panel.add(tfEnunciat);
			tfEnunciat.setColumns(10);
			
			tfR1 = new JTextField();
			tfR1.setColumns(10);
			tfR1.setBounds(175, 167, 448, 20);
			panel.add(tfR1);
			
			JLabel lbR2 = new JLabel("Resposta 2:");
			lbR2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbR2.setBounds(33, 247, 132, 32);
			panel.add(lbR2);
			
			JLabel lbR3 = new JLabel("Resposta 3:");
			lbR3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbR3.setBounds(33, 338, 132, 32);
			panel.add(lbR3);
			
			JLabel lbRCorrecta = new JLabel("Resposta Correcta:");
			lbRCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbRCorrecta.setBounds(33, 428, 132, 32);
			panel.add(lbRCorrecta);
			
			tfR2 = new JTextField();
			tfR2.setColumns(10);
			tfR2.setBounds(175, 255, 448, 20);
			panel.add(tfR2);
			
			tfR3 = new JTextField();
			tfR3.setColumns(10);
			tfR3.setBounds(175, 346, 448, 20);
			panel.add(tfR3);
			
			tfRespostaCorrecta = new JTextField();
			tfRespostaCorrecta.setColumns(10);
			tfRespostaCorrecta.setBounds(175, 436, 448, 20);
			panel.add(tfRespostaCorrecta);
			
			JButton jbGuardar = new JButton("Guardar");
			jbGuardar.setBounds(33, 490, 238, 43);
			panel.add(jbGuardar);
			
			jbGuardar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//Crear json i inseri a la bd
					
				}
			});
		}

	
}
