package desktopDuo.JFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Activitats.ATest;
import Activitats.ATrLliure;
import libDuo.Dao.ICategoriaDAO;
import libDuo.Dao.ICursDAO;
import libDuo.Dao.IExercici;
import libDuo.Dao.IIdiomaDAO;

import libDuo.Dao.INivellsDAO;
import libDuo.implement.CategoriaImpl;
import libDuo.implement.CursImpl;
import libDuo.implement.ExerciciImpl;
import libDuo.implement.IdiomaImpl;
import libDuo.implement.NivellsImpl;

import libDuo.implement.CategoriaImpl;
import libDuo.implement.CursImpl;
import libDuo.implement.IdiomaImpl;

import libDuo.model.Categoria;
import libDuo.model.Curs;
import libDuo.model.Exercici;
import libDuo.model.Idioma;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class baseJFrame extends JFrame {

	private JPanel contentPane, panelAA;
	private String i1,i2;
	private ArrayList<String> aNomIdiomesOrigen;
	
	private Boolean combinacio;
	private JList list;

	
	private Idioma idiomaDesti = new Idioma();
	private Idioma idiomaOrigen = new Idioma();
	
	private Curs cursActual;
	private long idCursActual;
	
	private JFrame afegirActivitat;
	

	private static JFrame frame;
	private static JTextField tfEnunciat;
	private static JTextField tfR1;
	private static JTextField tfR2;
	private static JTextField tfR3;
	private static JTextField tfRespostaCorrecta;
	
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
				administrarCurs();
			}
		});
		mnMenu.add(mntmAdminCursos);
		
		JMenuItem mntmItem2 = new JMenuItem("Item 2");
		mntmItem2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
		});
		mnMenu.add(mntmItem2);
		
		JMenuItem mntmItem3 = new JMenuItem("Item 3");
		mnMenu.add(mntmItem3);
		
		JMenu mnSubMenu = new JMenu("Sub Menu");
		mnMenu.add(mnSubMenu);
		
		JMenuItem mntmItem4 = new JMenuItem("Item 4");
		mnSubMenu.add(mntmItem4);
		getContentPane().setLayout(null);
		
	}
	public void administrarCurs() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));	
		
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Cursos existents (filtrar por origen i/o desti)");
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
		
		
		JLabel lblIdiomaDe = new JLabel("Idioma de desti");
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
		
		JButton btnAfegirExcercici = new JButton("AFEGIR PREGUNTA");
		btnAfegirExcercici.setBounds(34, 357, 699, 17);
		contentPane.add(btnAfegirExcercici);
		btnAfegirExcercici.setEnabled(false);
		
		btnAfegirExcercici.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				afegirActivitat();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("VISUALITZAR PREGUNTES");
		btnNewButton_1.setBounds(33, 386, 700, 15);
		contentPane.add(btnNewButton_1);
		
		
		btnAFiltro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				i1=comboBox.getSelectedItem().toString();
				i2=comboBox2.getSelectedItem().toString();
				IIdiomaDAO icmanagerIdioma = new IdiomaImpl();
				idiomaDesti = icmanagerIdioma.getIdiomaByName(i2);
				idiomaOrigen = icmanagerIdioma.getIdiomaByName(i1);
				
				defaultListModelCursos.removeAllElements();
				defaultListModelCategoria.removeAllElements();
				defaultListModelNivell.removeAllElements();
				btnAfegirExcercici.setEnabled(false);
				btnAfegirNivell.setEnabled(false);
				btnAfegirCategoria.setEnabled(false);
				btnCCurs.setEnabled(false);
				
				ICursDAO icmanagerCurs = new CursImpl();
				
				ArrayList<Curs> arrayListTotsElsCursos = new ArrayList<Curs>();
				
				arrayListTotsElsCursos = icmanagerCurs.getAllCursos();
				//arrayListTotsElsCursos = recurllirTotsElsCursos(icmanagerCurs, arrayListTotsElsCursos);
				if(!i1.equals(" ") && !i2.equals(" ")) {
					boolean combinacio = recullirIdiomaDestiIdiomaOrigen(i1, i2, arrayListTotsElsCursos);
					if(combinacio) {
						defaultListModelCursos.addElement(i1+" - "+i2);
					}else {
						btnCCurs.setEnabled(true);
						
						
					}
				}else if(!i1.equals(" ") && i2.equals(" ")) {
					for (int i = 0; i < arrayListTotsElsCursos.size(); i++) {
						if(arrayListTotsElsCursos.get(i).getIdiomaOrigen().getIdioma().equalsIgnoreCase(i1)) {
							defaultListModelCursos.addElement(arrayListTotsElsCursos.get(i).getIdiomaOrigen().getIdioma()+
									" - "+arrayListTotsElsCursos.get(i).getIdiomaDesti().getIdioma());
							
						}
					}
				}else if(i1.equals(" ") && !i2.equals(" ")) {
					for (int i = 0; i < arrayListTotsElsCursos.size(); i++) {
						if(arrayListTotsElsCursos.get(i).getIdiomaDesti().getIdioma().equalsIgnoreCase(i2)) {
							defaultListModelCursos.addElement(arrayListTotsElsCursos.get(i).getIdiomaOrigen().getIdioma()+
									" - "+arrayListTotsElsCursos.get(i).getIdiomaDesti().getIdioma());
							
						}
					}
				}
				
				
			}
		});
		
		btnCCurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ICursDAO icmanagerCurs = new CursImpl();
				IIdiomaDAO icmanagerIdioma = new IdiomaImpl();
				defaultListModelCursos.addElement(i1+"-"+i2);
				Curs curs = new Curs();
				idiomaDesti = icmanagerIdioma.getIdiomaByName(i2);
				idiomaOrigen = icmanagerIdioma.getIdiomaByName(i1);
				
				icmanagerCurs.setNewCurs(idiomaOrigen,idiomaDesti, curs);
				btnCCurs.setEnabled(false);
			}
		});
		
		//Afegir Categoria
		ICategoriaDAO icmanagerCategoria = new CategoriaImpl();
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ICursDAO icManagerCurs = new CursImpl();
				//System.out.println(list.getSelectedValue().toString());
				Curs cursActualLocal = icManagerCurs.getCursByNom(list.getSelectedValue().toString());
				System.out.println(cursActualLocal.getNomCurs());
				System.out.println(cursActualLocal.getIdCurs());
				defaultListModelCategoria.removeAllElements();
				
				
				btnAfegirCategoria.setEnabled(true);
				
				//String[] idiomesPos = list.getSelectedValue().toString().split("-");
				ArrayList<Categoria> arrayTotesCategories = new ArrayList<Categoria>();
				arrayTotesCategories = icmanagerCategoria.getAllCategorias();
				ArrayList<Categoria> arrayCategoriaCurs = new ArrayList<Categoria>();
				
				for (int i = 0; i < arrayTotesCategories.size(); i++) {
					if(arrayTotesCategories.get(i).getCurs().getIdCurs()==cursActualLocal.getIdCurs()) {
						arrayCategoriaCurs.add(arrayTotesCategories.get(i));
						defaultListModelCategoria.addElement(arrayCategoriaCurs.get(i).getTipusCategoria());
					}
				}
				
				
				//ArrayList<Categoria> arrayCategoriaCurs = icmanagerCategoria.getAllCategoriesByIdiomaOrigen(icmanagerCurs.getCursByIds(idIdiomaOrgien, idIdiomaDesti));
//				if(cursActualLocal != null) {
//					arrayCategoriaCurs = (ArrayList<Categoria>) icmanagerCategoria.getAllCategoriesByCurs(cursActualLocal);
//					for (int i = 0; i < arrayCategoriaCurs.size(); i++) {
//						System.out.println(arrayCategoriaCurs.get(i).getTipusCategoria());
//						defaultListModelCategoria.addElement(arrayCategoriaCurs.get(i).getTipusCategoria());
//					}
//				}
				
				arrayCategoriaCurs.clear();
				
				
			}
		});
		btnAfegirCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				long idIdiomaOrgien = idiomaOrigen.getIdIdioma();
				long idIdiomaDesti = idiomaDesti.getIdIdioma();
				String seleccion = JOptionPane.showInputDialog(baseJFrame.this,"Nom nova categoria",JOptionPane.QUESTION_MESSAGE);
				ICursDAO icmanagerCurs = new CursImpl();
				cursActual = icmanagerCurs.getCursByIds(idIdiomaOrgien, idIdiomaDesti);
				if(cursActual != null) {
					icmanagerCategoria.setNovaCategoria(seleccion, cursActual);
					defaultListModelCategoria.addElement(seleccion);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR AMB EL CURS", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
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
						
						Categoria categoria = icmanagerCategoria.getCategoriaByIdCurs(cursActual.getIdCurs());
						if(seleccion != null) {
							//icmanagerNivell.setNouNivell(seleccion, 0, categoria);
							defaultListModelNivell.addElement(seleccion);
						}
						else {
							JOptionPane.showMessageDialog(null, "ERROR AMB EL CURS", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
						
					}
				});
			}
		});
		
		list_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAfegirExcercici.setEnabled(true);
				
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
	public void afegirActivitat() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panelAA = new JPanel();
		panelAA.setBounds(0, 0,screenSize.width, screenSize.height);
		panelAA.setLayout(new BorderLayout(0, 0));	
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.BLACK));
		panel1.setBounds(0, 0, (panelAA.getWidth()/100)*30, panelAA.getHeight());
		

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(Color.BLACK));
		panel2.setBounds((panelAA.getWidth()/100)*30, 0,  (panelAA.getWidth()/100)*70, panelAA.getHeight());
		
		int wPanelD=(int)(panelAA.getWidth()/100)*30;
		
		
		int hPanelD=(int)(panel2.getHeight()/100);
		


		JButton Btest = new JButton("");
		Btest.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"TestIMG.PNG", Btest));
		Btest.setBounds((wPanelD)+45, hPanelD*20, 150, 75);
		Btest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ATest.initialize();
			}
		});
		
		panel2.add(Btest);


		panel2.setLayout(null);


		JButton Bcomplet = new JButton("");
		Bcomplet.setBounds((wPanelD)+90+150, hPanelD*20,  150, 75);
		Bcomplet.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"Completar1IMG.png", Bcomplet));
		panel2.add(Bcomplet);

		JButton Blisten = new JButton("");
		Blisten.setBounds((wPanelD)+20, hPanelD*40,  150, 75);
		Blisten.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"ListeningIMG.png", Blisten));
		panel2.add(Blisten);

		JButton Bordenar = new JButton("");
		Bordenar.setBounds((wPanelD)+50+150, hPanelD*40,  150, 75);
		Bordenar.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"OrderIMG.png", Bordenar));
		panel2.add(Bordenar);

		JButton BOrdenList = new JButton("");
		BOrdenList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BOrdenList.setBounds((wPanelD)+90+150*2, hPanelD*40,  150, 75);
		BOrdenList.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"Order-ListeningIMG.png", BOrdenList ));
		panel2.add(BOrdenList);

		JButton BRelation = new JButton("");

		BRelation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BRelation.setBounds((wPanelD)+45, hPanelD*60 ,  150, 75);
		BRelation.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"RelaciionIMG.png", BRelation));
		panel2.add(BRelation);

		JButton BWriter = new JButton("");
		BWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ATrLliure.initialize();
			}
		});
		BWriter.setBounds((wPanelD)+90+150, hPanelD*60,  150, 75);
		BWriter.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"WriteIMG.png", BWriter));
		panel2.add(BWriter);
		panel1.setLayout(null);

		JList list = new JList();
		list.setBorder(new LineBorder(Color.GRAY));
		list.setBounds(25, (screenSize.height/100)*20, (screenSize.width/100)*30-50, (screenSize.height/100)*50);
		panel1.add(list);

		JLabel lblNewLabel = new JLabel("Idioma Origen - Desti");
		lblNewLabel.setBounds((screenSize.width/100)*1, (screenSize.height/100)*5, 162, 15);
		panel1.add(lblNewLabel);

		JLabel lblNivell = new JLabel("Nivell");
		lblNivell.setBounds((screenSize.width/100)*1,(screenSize.height/100)*15, 70, 15);
		panel1.add(lblNivell);
		panelAA.add(panel1);
		panelAA.add(panel2);
		panel1.setVisible(true);
		panel2.setVisible(true);
		panelAA.setVisible(true);
		setContentPane(panelAA);

	}
	public Icon setIcono(String url , JButton boton) {

		ImageIcon imagen = new ImageIcon(url);
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT));
		return icono;
	}
	
	



}
