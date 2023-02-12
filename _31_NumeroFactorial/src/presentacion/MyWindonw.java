package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		//Dandole accion al botonFactorial
		botonFactorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(celdaFactorial.getText());
				int result=sacarFactorial(num);
				resultado.setText("El numero factorial de "+num+" es "+result);
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
		int factorial=1;
		for(int i=1;i<=N;i++) {
			factorial*=i;
		}
		return factorial;
	}
}