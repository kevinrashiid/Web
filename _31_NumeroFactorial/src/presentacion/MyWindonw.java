package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyWindonw extends JFrame {
	
	public MyWindonw(){
		super("Primera ventana");
		this.setBounds(100,50,700,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		componentes();
		this.setVisible(true);
	}
	void componentes() {
		getContentPane().setLayout(null);
		
		//creando objeto
		JLabel num=new JLabel("Introduce numero: ");
		JTextField celdaFactorial=new JTextField();
		JButton botonFactorial=new JButton("Factorial");
		JLabel resultado=new JLabel();
		
		//dando lugar a los objetos
		num.setBounds(150, 58, 150, 30);
		celdaFactorial.setBounds(150,100,150,30);
		botonFactorial.setBounds(150, 140, 200, 30);
		resultado.setBounds(150, 190, 200, 30);
		
		//Dandole accion/evento al botonFactorial
		botonFactorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(celdaFactorial.getText());
				int result=sacarFactorial(num);
				resultado.setText("El numero factorial de "+num+" es "+result);
			}
		});
		
		//añadimos componentes 
		getContentPane().add(num);
		getContentPane().add(botonFactorial);
		getContentPane().add(celdaFactorial);
		getContentPane().add(resultado);
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