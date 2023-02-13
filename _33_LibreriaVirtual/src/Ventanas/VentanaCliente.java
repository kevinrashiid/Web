package Ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import serviceClientes.ClientesService;
import serviceClientes.LibreriaServiceFactory;
import serviceLibros.LibrosService;

public class VentanaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField celdaUsuario;
	private JPasswordField pwd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jl = new JLabel("Usuario");
		jl.setBounds(59, 73, 45, 13);
		contentPane.add(jl);
		
		JLabel jl2 = new JLabel("Contraseña");
		jl2.setBounds(59, 99, 45, 13);
		contentPane.add(jl2);
		
		celdaUsuario = new JTextField();
		celdaUsuario.setBounds(111, 70, 96, 19);
		contentPane.add(celdaUsuario);
		celdaUsuario.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(121, 96, 86, 20);
		contentPane.add(pwd);
		
		JButton bLogin = new JButton("Login");
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesService service=LibreriaServiceFactory.getClientesService();
				LibrosService librosService=LibreriaServiceFactory.getLibrosService();
				String mensaje;
				if(service.existeContacto(celdaUsuario.getText(), pwd.getText())) {
					//creamos la ventana de libros y le pasamos la lista de libros
					//para que los muestre
					new VentanaLibros(librosService.listaDeLibros());
				}
			}
		});
		bLogin.setBounds(122, 125, 85, 21);
		contentPane.add(bLogin);
	}
}