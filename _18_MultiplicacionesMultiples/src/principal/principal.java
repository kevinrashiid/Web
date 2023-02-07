package principal;

import multiplicaciones.TablasDeMultiplicaciones;

public class principal {

	public static void main(String[] args) {
		//la tabla del 4 
		TablasDeMultiplicaciones t1=new TablasDeMultiplicaciones(4);
		//la tabla de 9 
		TablasDeMultiplicaciones t2=new TablasDeMultiplicaciones(9);
		
		new Thread(t1).start();
		new Thread(t2).start();
	}
}