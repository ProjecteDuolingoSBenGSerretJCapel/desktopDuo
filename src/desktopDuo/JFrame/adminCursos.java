package desktopDuo.JFrame;

import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import libDuo.Dao.*;
import libDuo.implement.*;
import libDuo.model.*;



public class adminCursos extends JFrame {

	private JPanel contentPane;
	private String i1,i2;
	private ArrayList<String> aNomIdiomesOrigen;
	

	
	public adminCursos() {
		i1="";
		i2="";
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800,450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		btnAFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i1=comboBox.getSelectedItem().toString();
				i2=comboBox2.getSelectedItem().toString();
				aplicarFiltres(i1,i2);
			}
		});
		
		btnAFiltro.setBounds(456, 17, 163, 24);
		panel.add(btnAFiltro);
		
		
		JButton btnCCurs = new JButton("Crear curs");
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
		
		List list = new List();
		list.setBounds(31, 147, 139, 154);
		contentPane.add(list);
		
		List list_1 = new List();
		list_1.setBounds(255, 147, 153, 154);
		contentPane.add(list_1);
		
		List list_2 = new List();
		list_2.setBounds(499, 147, 153, 154);
		contentPane.add(list_2);
		
		JButton btnAfegirCategoria = new JButton("Afegir categoria");
		btnAfegirCategoria.setBounds(255, 330, 153, 15);
		contentPane.add(btnAfegirCategoria);
		
		JButton btnAfegirNivell = new JButton("Afegir nivell");
		btnAfegirNivell.setBounds(499, 330, 117, 15);
		contentPane.add(btnAfegirNivell);
		
		JButton btnNewButton = new JButton("AFEGIR PREGUNTA");
		btnNewButton.setBounds(34, 357, 699, 17);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VISUALITZAR PREGUNTES");
		btnNewButton_1.setBounds(33, 386, 700, 15);
		contentPane.add(btnNewButton_1);
		
		setVisible(true);
	}
	public void aplicarFiltres(String i1, String i2) {
		
		
		ICursDAO icmanager = new CursImpl();
		System.out.println(i1+" "+i2);
		ArrayList<Curs> aC=(ArrayList<Curs>) icmanager.getAllCursos();
		
		for (int i = 0; i < aC.size(); i++) {
			if(aC.get(i).getIdiomaOrigen().getIdioma().equalsIgnoreCase(i1) && aC.get(i).getIdiomaDesti().getIdioma().equalsIgnoreCase(i2) ) {
				aNomIdiomesOrigen.add(aC.get(i).getIdiomaOrigen().getIdioma()+"-"+aC.get(i).getIdiomaDesti().getIdioma());
				System.out.println(aNomIdiomesOrigen.toString());
			}
		}
		

	}
}
