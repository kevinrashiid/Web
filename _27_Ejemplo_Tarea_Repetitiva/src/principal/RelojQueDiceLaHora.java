package principal;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RelojQueDiceLaHora {

	public static void main(String[] args) throws InterruptedException {
		//tarea que cada segundo muestra la hora
		ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(()->System.out.println(LocalTime.now()), 0, 1, TimeUnit.SECONDS);
		//lo dormimos
		Thread.sleep(200);
		//le da tiempo a que solo imprima una vez la hora con el shudownNow
		executor.shutdownNow();
	}
}