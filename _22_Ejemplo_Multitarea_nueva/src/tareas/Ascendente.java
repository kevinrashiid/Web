package tareas;

public class Ascendente implements Runnable {
//para utilizar multitarea debemos hereadar Thread para utilizar sus metodos
	//o podemos utilizar el Runnable
	@Override
	public void run() {

		for(int i=1;i<=100;i++) {
			System.out.println("Ascendente: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}