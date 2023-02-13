package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyWindonw extends JFrame {
	
	public MyWindonw(){
		super("Primera ventana");
		this.setBounds(100,50,700,500);
		//que no haga nada el boton de cierre
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		componentes();
		this.setVisible(true);
	}
	void componentes() {
		this.setLayout(null);
		
		//creando objeto
		JLabel num=new JLabel("Introduce numero: ");
		JTextField celdaFactorial=new JTextField();
		JButton botonFactorial=new JButton("Factorial");
		JLabel resultado=new JLabel();
		
		//dando lugar a los objetos
		num.setBounds(150, 50, 150, 30);
		celdaFactorial.setBounds(150,100,150,30);
		botonFactorial.setBounds(300, 170, 200, 30);
		resultado.setBounds(150, 200, 200, 30);

		//Dandole accion/evento al botonFactorial
		botonFactorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(celdaFactorial.getText());
				int result=sacarFactorial(num);
				resultado.setText("El numero factorial de "+num+" es "+result);
			}
		});
		//Preguntar al cerrar y cambiar al minimizar
		this.addWindowListener(new WindowAdapter() {

			@Override //este metodo es para preguntar si quieres salir al darle a la X de cerrar
			public void windowClosing(WindowEvent e) {
				//cerramos la ventana //devuelve un entero
				int res=JOptionPane.showConfirmDialog(MyWindonw.this, "¿Seguro que quieres salir?");
				//si dice que si se cierra con dispose
				if(res==JOptionPane.YES_OPTION) {
					MyWindonw.this.dispose();
				}	
			}
			@Override //este metodo es para cambiar el color 
			public void windowActivated(WindowEvent e) {
				//para cambiar el color  de la ventana con un color aleatorio
				Color color=new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
				MyWindonw.this.getContentPane().setBackground(color);
			}			
		});

		//añadimos componentes 
		this.add(num);
		this.add(botonFactorial);
		this.add(celdaFactorial);
		this.add(resultado);
	}

	//metodo para sacar factorial de N numeros
	public int sacarFactorial(int N) {
		//Sacarlo con Stream
		//este Stream
		//recude necesita dos parametros
		//y lo que hace es que reduce todo a una operacion
		return IntStream
				.rangeClosed(1, N)
				.reduce(1, (a,b)->a*b);

		//Sacarlo el factorial de forma cutre
		/*int factorial=1;
		for(int i=1;i<=N;i++) {
			factorial*=i;
		}
		return factorial;*/
	}
}