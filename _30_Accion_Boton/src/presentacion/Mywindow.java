package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		this.setLayout(null);
		JButton bt=new JButton("Iniciar sesion");
		JLabel lb=new JLabel("");
		JButton salir=new JButton("salir");

		bt.setBounds(50, 50, 108, 30);
		salir.setBounds(200, 200, 108, 30);
		lb.setBounds(200, 250, 200, 30);

		//luego de aver dado el tamaño color se le da la accion
		//con este metodo y una expresion lamda
		//le damos la accion al boton de salir que cuando le demos salir cierre la ventana
		salir.addActionListener(e->Mywindow.this.dispose());
		//creamos una ventado con el texto que queremos
		bt.addActionListener(e->JOptionPane.showConfirmDialog(Mywindow.this, "Bienvenido a Swing"));
		//ahora al darle al iniciar sesion te muestra un JLabel
		//bt.addActionListener(e->lb.setText("texto cambiado"));
		
		//añadir el control a la ventana 
		this.add(bt);
		this.add(salir);
		this.add(lb);
	}
}