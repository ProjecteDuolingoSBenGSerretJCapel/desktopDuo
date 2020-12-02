package desktopDuo.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class baseJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baseJFrame frame = new baseJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public baseJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		 setLocationRelativeTo(null);
		 
		 
		
		 Toolkit icona = Toolkit.getDefaultToolkit();
		 Image logo = icona.getImage("imgs"+File.separator+"Logo.png");
		 this.setIconImage(new ImageIcon (logo).getImage());
		 
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAdminCursos = new JMenuItem("Administrar Cursos");
		mntmAdminCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new adminCursos();
			}
		});
		mnMenu.add(mntmAdminCursos);
		
		JMenuItem mntmItem2 = new JMenuItem("Item 2");
		mnMenu.add(mntmItem2);
		
		JMenuItem mntmItem3 = new JMenuItem("Item 3");
		mnMenu.add(mntmItem3);
		
		JMenu mnSubMenu = new JMenu("Sub Menu");
		mnMenu.add(mnSubMenu);
		
		JMenuItem mntmItem4 = new JMenuItem("Item 4");
		mnSubMenu.add(mntmItem4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
