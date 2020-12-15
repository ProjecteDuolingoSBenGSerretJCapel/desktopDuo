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
import libDuo.model.Nivells;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class baseJFrame extends JFrame {

	private JPanel panelAdministrarCurs, panelAfegirActivitat;
	private String idiomaOr,idiomaDes;
	private ArrayList<String> aNomIdiomesOrigen;
	
	private Boolean combinacio;
	private JList listCurs;

	
	private Idioma idiomaDesti = new Idioma();
	private Idioma idiomaOrigen = new Idioma();
	
	private Curs cursActual;
	private Categoria categoriaActual;
	private Nivells nivellActual;
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
		panelAdministrarCurs = new JPanel();
		panelAdministrarCurs.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAdministrarCurs.setLayout(new BorderLayout(0, 0));	
		
		setContentPane(panelAdministrarCurs);
		JLabel lblIOrigen = new JLabel("Cursos existents (filtrar por origen i/o desti)");
		lblIOrigen.setBounds(43, 0, 470, 15);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(43, 25, 718, 89);
		panelAdministrarCurs.setLayout(null);
		panelAdministrarCurs.add(lblIOrigen);
		panelAdministrarCurs.add(panel);
		panel.setLayout(null);
		
		JLabel lblIOrigen_1 = new JLabel("Idioma de origen");
		lblIOrigen_1.setBounds(12, 22, 163, 15);
		panel.add(lblIOrigen_1);
		
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
		panelAdministrarCurs.add(lblCursos);
		
		JLabel lblCategoriasDelCurs = new JLabel("Categorias del curs sel·leccionat");
		lblCategoriasDelCurs.setBounds(211, 126, 241, 15);
		panelAdministrarCurs.add(lblCategoriasDelCurs);
		
		JLabel lblNivelesDeLa = new JLabel("Nivells de la categoria sel·leccionada");
		lblNivelesDeLa.setBounds(464, 126, 297, 15);
		panelAdministrarCurs.add(lblNivelesDeLa);
		
		
		DefaultListModel defaultListModelCursos = new DefaultListModel<>();
		
		JScrollPane scrollPaneCurs = new JScrollPane();
		scrollPaneCurs.setBounds(31, 147, 160, 154);
		panelAdministrarCurs.add(scrollPaneCurs);
		
		listCurs = new JList();
		
		scrollPaneCurs.setViewportView(listCurs);
		
		listCurs.setModel(defaultListModelCursos);
		
		DefaultListModel defaultListModelCategoria = new DefaultListModel<>();
		
		JScrollPane scrollPaneCat = new JScrollPane();
		scrollPaneCat.setBounds(255, 147, 160, 154);
		panelAdministrarCurs.add(scrollPaneCat);
		
		JList listCategoria = new JList();
		scrollPaneCat.setViewportView(listCategoria);
		
		listCategoria.setModel(defaultListModelCategoria);
		
		JScrollPane scrollPaneNiv = new JScrollPane();
		scrollPaneNiv.setBounds(499, 147, 160, 154);
		panelAdministrarCurs.add(scrollPaneNiv);
		
		DefaultListModel defaultListModelNivell = new DefaultListModel<>();
		JList listNivell = new JList();
		
		scrollPaneNiv.setViewportView(listNivell);
		
		listNivell.setModel(defaultListModelNivell);
		
		JButton btnAfegirCategoria = new JButton("Afegir categoria");
		btnAfegirCategoria.setBounds(255, 330, 153, 15);
		panelAdministrarCurs.add(btnAfegirCategoria);
		btnAfegirCategoria.setEnabled(false);
		
		JButton btnAfegirNivell = new JButton("Afegir nivell");
		btnAfegirNivell.setBounds(499, 330, 117, 15);
		panelAdministrarCurs.add(btnAfegirNivell);
		btnAfegirNivell.setEnabled(false);
		
		JButton btnAfegirExcercici = new JButton("AFEGIR PREGUNTA");
		btnAfegirExcercici.setBounds(34, 357, 699, 17);
		panelAdministrarCurs.add(btnAfegirExcercici);
		btnAfegirExcercici.setEnabled(false);
		
		btnAfegirExcercici.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				afegirActivitat();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("VISUALITZAR PREGUNTES");
		btnNewButton_1.setBounds(33, 386, 700, 15);
		panelAdministrarCurs.add(btnNewButton_1);
		
		
		btnAFiltro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				idiomaOr=comboBox.getSelectedItem().toString();
				idiomaDes=comboBox2.getSelectedItem().toString();
				IIdiomaDAO icmanagerIdioma = new IdiomaImpl();
				idiomaDesti = icmanagerIdioma.getIdiomaByName(idiomaDes);
				idiomaOrigen = icmanagerIdioma.getIdiomaByName(idiomaOr);
				
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
				if(!idiomaOr.equals(" ") && !idiomaDes.equals(" ")) {
					boolean combinacio = recullirIdiomaDestiIdiomaOrigen(idiomaOr, idiomaDes, arrayListTotsElsCursos);
					if(combinacio) {
						defaultListModelCursos.addElement(idiomaOr+" - "+idiomaDes);
					}else {
						btnCCurs.setEnabled(true);
						
						
					}
				}else if(!idiomaOr.equals(" ") && idiomaDes.equals(" ")) {
					for (int i = 0; i < arrayListTotsElsCursos.size(); i++) {
						if(arrayListTotsElsCursos.get(i).getIdiomaOrigen().getIdioma().equalsIgnoreCase(idiomaOr)) {
							defaultListModelCursos.addElement(arrayListTotsElsCursos.get(i).getIdiomaOrigen().getIdioma()+
									" - "+arrayListTotsElsCursos.get(i).getIdiomaDesti().getIdioma());
							
						}
					}
				}else if(idiomaOr.equals(" ") && !idiomaDes.equals(" ")) {
					for (int i = 0; i < arrayListTotsElsCursos.size(); i++) {
						if(arrayListTotsElsCursos.get(i).getIdiomaDesti().getIdioma().equalsIgnoreCase(idiomaDes)) {
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
				defaultListModelCursos.addElement(idiomaOr+" - "+idiomaDes);
				Curs curs = new Curs();
				idiomaDesti = icmanagerIdioma.getIdiomaByName(idiomaDes);
				idiomaOrigen = icmanagerIdioma.getIdiomaByName(idiomaOr);
				
				icmanagerCurs.setNewCurs(idiomaOrigen,idiomaDesti, curs);
				cursActual = icmanagerCurs.getCursByNom(idiomaOr+" - "+idiomaDes);
				System.out.println(cursActual.getNomCurs());
				btnCCurs.setEnabled(false);
			}
		});
		
		//Afegir Categoria
		ICategoriaDAO icmanagerCategoria = new CategoriaImpl();
		listCurs.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ICursDAO icManagerCurs = new CursImpl();
				cursActual = icManagerCurs.getCursByNom(listCurs.getSelectedValue().toString());
				defaultListModelCategoria.removeAllElements();
				defaultListModelNivell.removeAllElements();
				btnAfegirCategoria.setEnabled(true);
				ArrayList<Categoria> arrayCategoriaCurs = new ArrayList<Categoria>();
				
				if(cursActual != null) {
					arrayCategoriaCurs = (ArrayList<Categoria>) icmanagerCategoria.getAllCategoriesByCurs(cursActual);
					for (int i = 0; i < arrayCategoriaCurs.size(); i++) {
						defaultListModelCategoria.addElement(arrayCategoriaCurs.get(i).getTipusCategoria());
					}
				}
				
				arrayCategoriaCurs.clear();
				
				
			}
			
		});
		
		btnAfegirCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String seleccion = JOptionPane.showInputDialog(baseJFrame.this,"Nom nova categoria",JOptionPane.QUESTION_MESSAGE);
				ICursDAO icmanagerCurs = new CursImpl();
				if(cursActual != null && seleccion != null && seleccion != "") {
					icmanagerCategoria.setNovaCategoria(seleccion, cursActual);
					defaultListModelCategoria.addElement(seleccion);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR AMB EL CURS", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	
		
		
		//Afegir nivell ------------------------------------
		
		INivellsDAO icmanagerNivell = new NivellsImpl();
		
		listCategoria.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				categoriaActual = icmanagerCategoria.getCategoriaByName(listCategoria.getSelectedValue().toString());
				defaultListModelNivell.removeAllElements();
				btnAfegirNivell.setEnabled(true);
				ArrayList<Nivells> arrayCategoriaNivells = new ArrayList<Nivells>();
				if(categoriaActual!=null) {
					arrayCategoriaNivells=(ArrayList<Nivells>) icmanagerNivell.getAllNivellsByCategoria(categoriaActual);
					for (int i = 0; i < arrayCategoriaNivells.size(); i++) {
						defaultListModelNivell.addElement(arrayCategoriaNivells.get(i).getNomNivell());
					}
				}
				arrayCategoriaNivells.clear();
				
				

			}
		});

		btnAfegirNivell.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {

				String seleccion = JOptionPane.showInputDialog(baseJFrame.this,"Nom nou nivell",JOptionPane.QUESTION_MESSAGE);

				if(seleccion != null && categoriaActual!=null && seleccion != "") {
					icmanagerNivell.setNouNivell(seleccion, 0, categoriaActual);
					defaultListModelNivell.addElement(seleccion);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR AMB LA CATEGORIA", "ERROR", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		listNivell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAfegirExcercici.setEnabled(true);
				nivellActual = icmanagerNivell.getNivellByName(listNivell.getSelectedValue().toString());

			}

		});


	}

	public ArrayList<Curs> recurllirTotsElsCursos(ICursDAO icmanager, ArrayList<Curs> arrayListTotsElsCursos) {
		arrayListTotsElsCursos = icmanager.getAllCursos();
		
		return arrayListTotsElsCursos;
	}
	
	
	
	public boolean recullirIdiomaDestiIdiomaOrigen(String idiomaOr, String idiomaDes, ArrayList<Curs> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
			if(arrayList.get(i).getIdiomaOrigen().getIdioma().equalsIgnoreCase(idiomaOr) 
					&& arrayList.get(i).getIdiomaDesti().getIdioma().equalsIgnoreCase(idiomaDes)) {
				return true;
			}
			
		}
		
		return false;
	}
	public void afegirActivitat() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panelAfegirActivitat = new JPanel();
		panelAfegirActivitat.setBounds(0, 0,screenSize.width, screenSize.height);
		panelAfegirActivitat.setLayout(new BorderLayout(0, 0));	
		
		JPanel panelEsquerra = new JPanel();
		panelEsquerra.setBorder(new LineBorder(Color.BLACK));
		panelEsquerra.setBounds(0, 0, (panelAfegirActivitat.getWidth()/100)*30, panelAfegirActivitat.getHeight());
		

		JPanel panelDreta = new JPanel();
		panelDreta.setBorder(new LineBorder(Color.BLACK));
		panelDreta.setBounds((panelAfegirActivitat.getWidth()/100)*30, 0,  (panelAfegirActivitat.getWidth()/100)*70, panelAfegirActivitat.getHeight());
		
		int wPanelD=(int)(panelAfegirActivitat.getWidth()/100)*30;
		
		
		int hPanelD=(int)(panelDreta.getHeight()/100);
		


		JButton Btest = new JButton("");
		Btest.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"TestIMG.PNG"));
		Btest.setBounds((wPanelD)+45, hPanelD*20, 150, 75);
		Btest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ATest.initialize();
			}
		});
		
		panelDreta.add(Btest);


		panelDreta.setLayout(null);


		JButton BCompletar = new JButton("");
		BCompletar.setBounds((wPanelD)+90+150, hPanelD*20,  150, 75);
		BCompletar.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"Completar1IMG.png"));
		panelDreta.add(BCompletar);

		JButton BEscolta = new JButton("");
		BEscolta.setBounds((wPanelD)+20, hPanelD*40,  150, 75);
		BEscolta.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"ListeningIMG.png"));
		panelDreta.add(BEscolta);

		JButton BOrdenar = new JButton("");
		BOrdenar.setBounds((wPanelD)+50+150, hPanelD*40,  150, 75);
		BOrdenar.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"OrderIMG.png"));
		panelDreta.add(BOrdenar);

		JButton BOrdenaEscolta = new JButton("");
		BOrdenaEscolta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BOrdenaEscolta.setBounds((wPanelD)+90+150*2, hPanelD*40,  150, 75);
		BOrdenaEscolta.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"Order-ListeningIMG.png" ));
		panelDreta.add(BOrdenaEscolta);

		JButton BRelaciona = new JButton("");

		BRelaciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BRelaciona.setBounds((wPanelD)+45, hPanelD*60 ,  150, 75);
		BRelaciona.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"RelaciionIMG.png"));
		panelDreta.add(BRelaciona);

		JButton BTradLliurer = new JButton("");
		BTradLliurer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ATrLliure.initialize();
			}
		});
		BTradLliurer.setBounds((wPanelD)+90+150, hPanelD*60,  150, 75);
		BTradLliurer.setIcon(setIcono("recursos"+File.separator+"imatgesButtons"+File.separator+"WriteIMG.png"));
		panelDreta.add(BTradLliurer);
		panelEsquerra.setLayout(null);

		JList listExercicis = new JList();
		listExercicis.setBorder(new LineBorder(Color.GRAY));
		listExercicis.setBounds(25, (screenSize.height/100)*20, (screenSize.width/100)*30-50, (screenSize.height/100)*50);
		panelEsquerra.add(listExercicis);

		JLabel lblIOrigen = new JLabel("Idioma Origen: "+cursActual.getIdiomaOrigen().getIdioma());
		lblIOrigen.setBounds((screenSize.width/100)*1, (screenSize.height/100)*5, 202, 15);
		panelEsquerra.add(lblIOrigen);
		
		JLabel lblIDesti = new JLabel("Idioma Desti: "+cursActual.getIdiomaDesti().getIdioma());
		lblIDesti.setBounds((screenSize.width/100)*1, (screenSize.height/100)*5+20, 202, 15);
		panelEsquerra.add(lblIDesti);
		
		JLabel lblCategoria = new JLabel("Categoria: "+categoriaActual.getTipusCategoria());
		lblCategoria.setBounds((screenSize.width/100)*1, (screenSize.height/100)*5+40, 202, 15);
		panelEsquerra.add(lblCategoria);
		
		JLabel lblNivellMostra = new JLabel("Nivell: "+nivellActual.getNomNivell());
		lblNivellMostra.setBounds((screenSize.width/100)*1, (screenSize.height/100)*5+60, 202, 15);
		panelEsquerra.add(lblNivellMostra);

		JLabel lblNivell = new JLabel("Nivell");
		lblNivell.setBounds((screenSize.width/100)*1,(screenSize.height/100)*15+10, 70, 15);
		panelEsquerra.add(lblNivell);
		panelAfegirActivitat.add(panelEsquerra);
		panelAfegirActivitat.add(panelDreta);
		panelEsquerra.setVisible(true);
		panelDreta.setVisible(true);
		panelAfegirActivitat.setVisible(true);
		setContentPane(panelAfegirActivitat);

	}
	public Icon setIcono(String url ) {

		ImageIcon imatge = new ImageIcon(url);
		ImageIcon icona= new ImageIcon(imatge.getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT));
		return icona;
	}
	
	



}
