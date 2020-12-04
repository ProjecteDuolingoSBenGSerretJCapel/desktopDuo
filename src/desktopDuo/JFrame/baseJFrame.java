package desktopDuo.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import libDuo.Dao.ICategoriaDAO;
import libDuo.Dao.ICursDAO;
import libDuo.Dao.IIdiomaDAO;
import libDuo.Dao.INivellsDAO;
import libDuo.implement.CategoriaImpl;
import libDuo.implement.CursImpl;
import libDuo.implement.IdiomaImpl;
import libDuo.implement.NivellsImpl;
import libDuo.model.Categoria;
import libDuo.model.Curs;
import libDuo.model.Idioma;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class baseJFrame extends JFrame {

	private JPanel contentPane;
	private String i1,i2;
	private ArrayList<String> aNomIdiomesOrigen;
	
	private Boolean combinacio;
	private JList list;

	
	private Idioma idiomaDesti = new Idioma();
	private Idioma idiomaOrigen = new Idioma();
	
	private Curs curs;
	
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
				//new adminCursos();
				administrarCurs();
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
		
	}
	public void administrarCurs() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));	
		
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Cursos existents (filtrar por origen i/o desti");
		lblNewLabel.setBounds(43, 0, 470, 15);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(43, 25, 718, 89);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Idioma de origen");
		lblNewLabel_1.setBounds(12, 22, 163, 15);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 53, 182, 24);
		
		panel.add(comboBox);
		
		
		JLabel lblIdiomaDe = new JLabel("Idioma de destí");
		lblIdiomaDe.setBounds(226, 22, 153, 15);
		panel.add(lblIdiomaDe);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(226, 53, 182, 24);
		panel.add(comboBox2);
		File idiomas=new File("recursos"+File.separator +"languageList.txt");
	
		try {
			FileReader fr = new FileReader (idiomas);
			BufferedReader bfr = new BufferedReader(fr);
			String idioma;
			comboBox2.addItem(" ");
			comboBox.addItem(" ");
			while((idioma=bfr.readLine())!=null) {
				comboBox2.addItem(idioma);
				comboBox.addItem(idioma);
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JButton btnAFiltro = new JButton("Aplicar filtro");		
		btnAFiltro.setBounds(456, 17, 163, 24);
		panel.add(btnAFiltro);
		
		
		JButton btnCCurs = new JButton("Crear curs");
		btnCCurs.setEnabled(false);
		btnCCurs.setBounds(456, 53, 163, 24);
		panel.add(btnCCurs);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(43, 126, 70, 15);
		contentPane.add(lblCursos);
		
		JLabel lblCategoriasDelCurs = new JLabel("Categorias del curs sel·leccionat");
		lblCategoriasDelCurs.setBounds(211, 126, 241, 15);
		contentPane.add(lblCategoriasDelCurs);
		
		JLabel lblNivelesDeLa = new JLabel("Nivells de la categoria sel·leccionada");
		lblNivelesDeLa.setBounds(464, 126, 297, 15);
		contentPane.add(lblNivelesDeLa);
		
		DefaultListModel defaultListModelCursos = new DefaultListModel<>();
		list = new JList();
		list.setBounds(31, 147, 139, 154);
		contentPane.add(list);
		
		list.setModel(defaultListModelCursos);
		
		DefaultListModel defaultListModelCategoria = new DefaultListModel<>();
		JList list_1 = new JList();
		list_1.setBounds(255, 147, 153, 154);
		contentPane.add(list_1);
		
		list_1.setModel(defaultListModelCategoria);
		
		DefaultListModel defaultListModelNivell = new DefaultListModel<>();
		JList list_2 = new JList();
		list_2.setBounds(499, 147, 153, 154);
		contentPane.add(list_2);
		
		list_2.setModel(defaultListModelNivell);
		
		JButton btnAfegirCategoria = new JButton("Afegir categoria");
		btnAfegirCategoria.setBounds(255, 330, 153, 15);
		contentPane.add(btnAfegirCategoria);
		btnAfegirCategoria.setEnabled(false);
		
		JButton btnAfegirNivell = new JButton("Afegir nivell");
		btnAfegirNivell.setBounds(499, 330, 117, 15);
		contentPane.add(btnAfegirNivell);
		btnAfegirNivell.setEnabled(false);
		
		JButton btnNewButton = new JButton("AFEGIR PREGUNTA");
		btnNewButton.setBounds(34, 357, 699, 17);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VISUALITZAR PREGUNTES");
		btnNewButton_1.setBounds(33, 386, 700, 15);
		contentPane.add(btnNewButton_1);
		
		ICursDAO icmanagerCurs = new CursImpl();
		btnAFiltro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				i1=comboBox.getSelectedItem().toString();
				i2=comboBox2.getSelectedItem().toString();
				
				ICursDAO icmanagerCurs = new CursImpl();
				IIdiomaDAO icmanagerIdioma = new IdiomaImpl();
				ArrayList<Curs> arrayListTotsElsCursos = new ArrayList<Curs>();
				arrayListTotsElsCursos = recurllirTotsElsCursos(icmanagerCurs, arrayListTotsElsCursos);
				
				boolean combinacio = recullirIdiomaDestiIdiomaOrigen(i1, i2, arrayListTotsElsCursos);
				defaultListModelCursos.removeAllElements();
				if(combinacio) {
					defaultListModelCursos.addElement(i1+"-"+i2);
					
					Curs curs = new Curs();
					idiomaDesti = icmanagerIdioma.getIdiomaByName(i1);
					idiomaOrigen = icmanagerIdioma.getIdiomaByName(i2);
					
					icmanagerCurs.setNewCurs(idiomaOrigen,idiomaDesti, curs);
					
					combinacio = false;
				}
				else {
					Curs curs = new Curs();
					idiomaDesti = icmanagerIdioma.getIdiomaByName(i1);
					idiomaOrigen = icmanagerIdioma.getIdiomaByName(i2);
					
					
					if(idiomaDesti != null && idiomaOrigen != null) {						
						btnCCurs.setEnabled(true);
						
						btnCCurs.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								defaultListModelCursos.addElement(i1+"-"+i2);
								icmanagerCurs.setNewCurs(idiomaOrigen,idiomaDesti, curs);
								btnCCurs.setEnabled(false);
							}
						});
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR EN LA BASE DE DATOS", "ERROR", JOptionPane.WARNING_MESSAGE);
					}
					combinacio = false;
					
				}
			}
		});
		ICategoriaDAO icmanagerCategoria = new CategoriaImpl();
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				long idIdiomaOrgien = idiomaOrigen.getIdIdioma();
				long idIdiomaDesti = idiomaDesti.getIdIdioma();
				
				btnAfegirCategoria.setEnabled(true);
				
				String[] idiomesPos = list.getSelectedValue().toString().split("-");
				
				ArrayList<Categoria> arrayCategoriaCurs = new ArrayList<Categoria>();
				//ArrayList<Categoria> arrayCategoriaCurs = icmanagerCategoria.getAllCategoriesByIdiomaOrigen(icmanagerCurs.getCursByIds(idIdiomaOrgien, idIdiomaDesti));
				
				for (int i = 0; i < arrayCategoriaCurs.size(); i++) {
					defaultListModelCursos.addElement(arrayCategoriaCurs.get(i).getTipusCategoria());
				}
				
				btnAfegirCategoria.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String seleccion = JOptionPane.showInputDialog(baseJFrame.this,"Nom nova categoria",JOptionPane.QUESTION_MESSAGE);
						
						curs = icmanagerCurs.getCursByIds(idIdiomaOrgien, idIdiomaDesti);
						if(curs != null) {
							icmanagerCategoria.setNovaCategoria(seleccion, curs);
							defaultListModelCategoria.addElement(seleccion);
						}
						else {
							JOptionPane.showMessageDialog(null, "ERROR AMB EL CURS", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				
			}
		});
		
		INivellsDAO icmanagerNivell = new NivellsImpl();
		int numNivell = 0;
		list_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAfegirNivell.setEnabled(true);
				btnAfegirNivell.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String seleccion = JOptionPane.showInputDialog(baseJFrame.this,"Nom nova categoria",JOptionPane.QUESTION_MESSAGE);
						
						Categoria categoria = icmanagerCategoria.getCategoriaByIdCurs(curs.getIdCurs());
						if(seleccion != null) {
							icmanagerNivell.setNouNivell(seleccion, 0, categoria);
							defaultListModelNivell.addElement(seleccion);
						}
						else {
							JOptionPane.showMessageDialog(null, "ERROR AMB EL CURS", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
						
					}
				});
			}
		});
	}
	
	public ArrayList<Curs> recurllirTotsElsCursos(ICursDAO icmanager, ArrayList<Curs> arrayListTotsElsCursos) {
		arrayListTotsElsCursos = icmanager.getAllCursos();
		
		return arrayListTotsElsCursos;
	}
	
	public boolean recullirIdiomaDestiIdiomaOrigen(String i1, String i2, ArrayList<Curs> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
			if(arrayList.get(i).getIdiomaOrigen().getIdioma().equalsIgnoreCase(i1) 
					&& arrayList.get(i).getIdiomaDesti().getIdioma().equalsIgnoreCase(i2)) {
				return true;
			}
			
		}
		
		return false;
	}
	
}
