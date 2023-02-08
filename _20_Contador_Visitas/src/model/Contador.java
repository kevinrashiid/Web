package model;

public class Contador {
	//esto es para simular la condiciones de Carreras
	//toda variable int inicializada como atributo se de la valor 0
	//multitarea clasica
	private int valor=0;
	//metodo que incrementa la variable valor
	//synchronized funciona como una fila como no acabe la primera la segunda no entra
	//esta solucion arreglo se llama Thread safe
	//pero hay otras posibilidades como la multitarea moderna
	public synchronized void incrementar(){
		int a=valor;
		a++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		valor=a;
	}
	
	//esto 
	public void descrementar(){
		synchronized(this) {
			int a=valor;
			a--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			valor=a;
		}
	}
	public int getValor() {
		return valor;
	}
}