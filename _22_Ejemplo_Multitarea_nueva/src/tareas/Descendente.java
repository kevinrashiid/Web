package tareas;

public class Descendente implements Runnable {

	@Override
	public void run() {
		
		for(int i=100;i>=0;i--) {
			System.out.println("Descendente: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
