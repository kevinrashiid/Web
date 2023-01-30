package view;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.CursoJavaBeans;

public class TestEscritura {

	public static void main(String[] args) {
		String url="/Users/kevinrashid/Documents/ficheros/Cursos.json";
		//escritura en un json
		/*CursoJavaBeans curso=new CursoJavaBeans("al1","JavaScript",6.7);
		//recuperamos el JSON completo. añadimos el objeto y despues
		//escribimos todo el contenido de nuevo
		try(FileWriter fw=new FileWriter(url);//modo escritura
			FileReader fr=new FileReader(url);){//modo lectura
			Gson gson=new Gson();
			CursoJavaBeans[] cursos=gson.fromJson(fr,CursoJavaBeans[].class);
			//esta instruccion crea un ArrayList a partir de un array
			ArrayList<CursoJavaBeans> lista=new ArrayList<>(List.of(cursos));
			//añadimos el nuevo curso
			lista.add(curso);
			//y escribimos en el fichero la lista
			gson.toJson(curso,fw);//curso->es lo que quiero escribir y fr->es donde lo quiero escribir
			System.out.println("curso guardado");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}*/
		CursoJavaBeans curso=new CursoJavaBeans("al4","JavaScript",6.7);
		//recuperamos el JSON completo. Añadimos el objeto, y después
		//escribimos todo el contenido de nuevo
		//esta instruccion crea un ArrayList a partir de un array
		//recuperamos el JSON completo. Añadimos el objeto, y después
		//escribimos todo el contenido de nuevo
		ArrayList<CursoJavaBeans> lista;
		Gson gson=new Gson();
		try(FileReader fr=new FileReader(url);){		
			CursoJavaBeans[] cursos=gson.fromJson(fr,CursoJavaBeans[].class);
			//esta instrucción crea un ArrayList a partir de un array
			lista=new ArrayList<>(List.of(cursos));
			//añadimos el nuevo curso
			lista.add(curso);			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return;
			
			
			
			
		}
		
		try(FileWriter fw=new FileWriter(url);){//modo sobrescritura
			//y escribimos en el fichero la lista entera
			gson.toJson(lista, fw);
			System.out.println("curso guardado!");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}