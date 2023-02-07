package multiplicaciones;

public class TablasDeMultiplicaciones implements Runnable{
	int numero;
	public TablasDeMultiplicaciones(int numero) {
		this.numero=numero;
	}
	@Override
	public void run() {
		for (int i=1;i<=10;i++) {
			System.out.println(numero+"x"+i+"="+numero*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}