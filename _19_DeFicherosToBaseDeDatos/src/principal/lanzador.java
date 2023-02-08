package principal;

import tareas.TareaTienda;

public class lanzador {

	public static void main(String[] args) {
		
		TareaTienda t1=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda1.csv");
		TareaTienda t2=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda2.csv");
		TareaTienda t3=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda3.csv");
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}
}