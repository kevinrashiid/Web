package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyWindow extends JFrame{
	
	public MyWindow()	{
		super("Iniciar sesion");
		this.setBounds(100, 50, 700, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.CYAN);
		componentes();
		this.setVisible(true);	
	}
	void componentes() {
		this.setLayout(null);
		JLabel user=new JLabel("Usuario:");
		JLabel contraseña=new JLabel("Contraseña:");

		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		
		JButton bt=new JButton("Iniciar sesion");
		
		user.setBounds(150,50,150,30);
		contraseña.setBounds(150, 100, 150, 30);
		t1.setBounds(350, 50, 200, 30);
		t2.setBounds(350, 100, 200, 30);
		bt.setBounds(300, 170, 200, 30);
		this.add(user);
		this.add(contraseña);		
		this.add(t1);
		this.add(t2);
		this.add(bt);	
	}
}
