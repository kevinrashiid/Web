package Ventanas;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Tema;
import presentacion.datamodel.AdaptadorListaDeLibrosPorTema;
import presentacion.datamodel.AdaptadorListaTemas;

public class VentanaConsultaLibros extends JFrame {

	private JPanel contentPane;
	private List<Tema> temas;
	private JTable tableLibros;
	public VentanaConsultaLibros(List<Tema> temas) {
		
		this.temas=temas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione tema");
		lblNewLabel.setBounds(118, 38, 184, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(63, 67, 282, 33);
		contentPane.add(scrollLista);
		
		JComboBox<Tema> comboTemas = new JComboBox<Tema>();
		comboTemas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//cogemos el tema seleccionado 
				Tema tema=(Tema)comboTemas.getSelectedItem();
				//creamos el adaptador de la tabla y se lo asignamos
				var adapter=new AdaptadorListaDeLibrosPorTema(tema.getIdTema());
				tableLibros.setModel(adapter);
			}
		});
		scrollLista.setViewportView(comboTemas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 416, 108);
		contentPane.add(scrollPane);
		
		tableLibros = new JTable();
		scrollPane.setViewportView(tableLibros);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//asisgnamos al comboBox el adaptor de los temas
				var adapter=new AdaptadorListaTemas();
				comboTemas.setModel(adapter);
				comboTemas.addItem(new Tema(0,"Seleccion uno"));	
			}
		});
		this.setVisible(true);
	}
}