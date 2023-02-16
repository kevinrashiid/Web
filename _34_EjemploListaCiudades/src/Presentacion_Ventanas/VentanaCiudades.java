package Presentacion_Ventanas;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Presentacion.datamodel.AdaptadorListaCiudades;
import model.Ciudad;
import service.CiudadService;

public class VentanaCiudades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCiudades frame = new VentanaCiudades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCiudades() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 61, 145, 92);
		contentPane.add(scrollPane);
		//objeto lista creado de tipo ciudad
		JList<Ciudad> listCiudades = new JList();
		listCiudades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//obtenemos el elemento(nombre de la ciudad) seleccionado y mostramos sus datos(la poblacion)
				/*Ciudad c=listCiudades.getSelectedValue();
				JOptionPane.showConfirmDialog(VentanaCiudades.this, c.getNombre()+":"+c.getPoblacion());*/
				
				//Preguntar si queremos eliminar esa ciudad, si dice que dice que SI se eliminara del ArrayList
				if(JOptionPane.showConfirmDialog(VentanaCiudades.this, "¿Deseada eliminar la ciudad?")==JOptionPane.YES_OPTION) {
					Ciudad c=listCiudades.getSelectedValue();
					CiudadService service=new CiudadService();
					service.eliminarCiudad(c.getNombre());
					//reasignar adaptador a la lista
					regenerarLista(listCiudades);
				}
			}
		});
		scrollPane.setViewportView(listCiudades);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//crear el adaptador con el modelo de datos y asignar 
				//al JList
				regenerarLista(listCiudades);
			}
		});
	}
	//metodo que actuliza lista 
	public void regenerarLista(JList<Ciudad> lista) {
		var adapter=new AdaptadorListaCiudades();
		
		lista.setModel(adapter);
	}
}