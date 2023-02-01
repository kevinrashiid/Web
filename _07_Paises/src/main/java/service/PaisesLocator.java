package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisesLocator {

	String url="/Users/kevinrashid/Documents/ficheros/otros/LosPaises.json"; 
	String ruta="https://restcountries.com/v2/all";
	Gson gson=new Gson();
	
	public Stream<Pais> getJsonStream(){
		
		/*
		try(FileReader fr=new FileReader(url);){
			Pais[]paises=gson.fromJson(fr, Pais[].class);
			return Arrays.stream(paises);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}*/
		
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(ruta)) //Builder
							.GET() //Builder
							.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
						.version(Version.HTTP_1_1)
						.build();
		//lanzar petición y objeto HttpResponse
		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			return Arrays.stream(gson.fromJson(response.body().toString(), Pais[].class)); //Stream<Pais>
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
}