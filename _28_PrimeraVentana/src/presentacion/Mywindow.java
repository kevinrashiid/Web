package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Mywindow extends JFrame{
	public Mywindow() {
		//le damos el titulo a traves del constructor de la superlclase
		super("Primera ventana");
		//posicion x-y que es 
		//el ancho que es el largo(w) y el ancho(h)
		//orden de setBounds x-y-w-h
		this.setBounds(100,50,700,500);
		//configurar boton de cierre de la ventana 
		//lo configuramos para que ahora al darle se cierre de verdad y no se oculte
		//hay que crear por cada cada ventana una CLASE
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//cambiamos el color de fondo pero no cambia por que tiene delante un panel 
		//a lo que hay que cambiar el color es al panel
		this.getContentPane().setBackground(Color.DARK_GRAY);
		//inicializamos componentes
		inicializarComponentes();
		
		//hacemos la ventana visible
		//true si quieres que se vea //false si no quieres que se vea
		this.setVisible(true);
	}	
	void inicializarComponentes() {
		//anular el gestor de organizacion(Layout)
		this.setLayout(null);;
		JButton bt=new JButton("Iniciar sesion");
		bt.setBounds(50, 50, 108, 30);
		//añadir el control a la ventana 
		this.add(bt);
		
	}
}