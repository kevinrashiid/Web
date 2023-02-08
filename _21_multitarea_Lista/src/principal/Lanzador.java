package principal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException {
		//creamos dos objetos de las clases Ascendente Descendente
		//List<String> textos=new ArrayList<>(); //NO thread Safe
		List<String> textos=new CopyOnWriteArrayList<>(); //SI Thread Safe
		Ascendente t1=new Ascendente(textos);
		Descendente t2=new Descendente(textos);
		//se ponen en ejecucion concurrente
		t1.start();
		t2.start();
		Thread.sleep(200);
		//los arrayList no son Thread safe
		//cuantas cadenas habra en la lista tras ejecutarse las dos tareas?
		//PREGUNTA
		//por que si ascendente mete 100 valores en la lista y descendente otros 100 
		//y luego preguntamos por su tamaño y no son 200 
		//la solucion esta en java.util.concurrent
		//CopyOnWriteArrayList es una version  Thread Safe de ArraysList
		//esta esta echa para entornos Thread Safe
		System.out.println(textos.size());
	}
}