package view;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import model.CursoJavaBeans;

public class TestLectura {

	public static void main(String[] args) {
		
		String url="/Users/kevinrashid/Documents/ficheros/Cursos.json";
		//leer el contenido del fichero y mostrar los datos de todos los cursos
		try(FileReader fr=new FileReader(url);){
			Gson gson=new Gson();
			//leer un json que esta en un fichero y trasladarlo a java
			//.class significa para que me vincule el fr que es el json a CursoJavaBeans para que se pueda utilizar
			CursoJavaBeans[] cursos=gson.fromJson(fr, CursoJavaBeans[].class);
			//recorremos 
			for(CursoJavaBeans c:cursos) {
				System.out.println(c.getCurso()+","+c.getCurso()+","+c.getNota());
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}	
}