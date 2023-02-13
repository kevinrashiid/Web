package _32_Factorial_Boton_WindonwBuilder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaFactorial extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFactorial frame = new VentanaFactorial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaFactorial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbRes = new JLabel("");
		JButton bt = new JButton("Factorial");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Esta es la mejor forma para darle accion a un boton
				lbRes.setText("Factorial: "+sacarFactorial(Integer.parseInt(tf.getText())));

			
				//esta es la forma cutre de hacerlo
				/*int num=Integer.parseInt(celdaFactorial.getText());
				int result=sacarFactorial(num);
				resultado.setText("El numero factorial de "+num+" es "+result);*/
			}
		});
		bt.setBounds(125, 108, 85, 21); 
		contentPane.add(bt);
		
		JLabel lblNewLabel = new JLabel("numero");
		lblNewLabel.setBounds(63, 78, 45, 13);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(115, 75, 96, 19);
		contentPane.add(tf);
		tf.setColumns(10);
		
		lbRes.setBounds(136, 182, 45, 13);
		contentPane.add(lbRes);
	}
	public int sacarFactorial(int N) {
		//Sacarlo con Stream este Stream recude necesita dos parametros
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
