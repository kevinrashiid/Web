package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import model.pedidos;
import service.locator.ConnectionLocator;

public class PedidosTiendasServiceIMPL implements PedidosTiendasService {
	
	//este metodo recibe la ruta del fichero 
	@Override
	public List<pedidos> pedidosTienda(String dirFichero) {
		Path pt=Path.of(dirFichero);
		try{
			return Files.lines(pt)//Stream<String>
			.map(s->{
				String[] datos=s.split("[,]");
				return new pedidos(0,datos[0],Integer.parseInt(datos[1]),LocalDate.parse(datos[2]));
			})
			.toList();
		}catch(IOException ex) {
			ex.printStackTrace();
			return List.of(); //lista vacía
		}
	}
	//
	@Override
	public void guardarPedido(pedidos pedido) {
		try(Connection con=ConnectionLocator.getConnection()){
			String sql="insert into pedidos(producto,unidade,fecha)values(?,?,?)";
			//por que no sabemos los datos y utilizamos ?,?,?
			//Y PreparedStatement por que no tenemos los datos es decir no lo sabemos
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, pedido.getNombreProducto());
			ps.setInt(2, pedido.getUnidadesProducto());
			ps.setDate(3, Date.valueOf(pedido.getFecha()));
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	//recibe una LISTA de pedidos y los guarda en la base de datos
	@Override
	public void guardarPedidos(List<pedidos> pedidoS) {
		try(Connection con=ConnectionLocator.getConnection();){
			//desactivamos autocomint para que todos los insert esten en la misma tx
			con.setAutoCommit(false);
			String sql="insert into pedidos(productos,unidades,fecha) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			for(pedidos s:pedidoS) {
				ps.setString(1, s.getNombreProducto());
				ps.setInt(2, s.getUnidadesProducto());
				ps.setDate(3, Date.valueOf(s.getFecha()));
				ps.execute();
			}
			//esto para que comfirmar la transacion
			con.commit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//metodo que suma el total de unidades
	@Override
	public int totalDeUnidades() {
		int total=0;
		try(Connection con=ConnectionLocator.getConnection();){
			//opcion 1 para 
			/*String sql="select unidades from pedidos";
			Statement ps=con.createStatement();
			//debemos convertir el LocalDate en java.sql.Date
			//las  sql select siempre llevan un ResultSet  
			ResultSet rs=ps.executeQuery(sql);
			//recorremos Resulset y sumamos todas las unidades
			while(rs.next()) {
				total+=rs.getInt("unidades");
			}*/
			/*Opcion 2: 
			Utilizar las --funciones de agregado--
			funciones de agregados son funciones para hacer calculos
			ejemplo una media(avg) una suma(sum) 
			lo que te devuelve sum es una suma*/
			String sql="select sum(unidades) from pedidos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();//nos desplazamos a la primera y unica fila
			total=rs.getInt(1);//y le pedidos el valor
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return total;
	}
	
	@Override
	public String productoUltimoProducto() {
		String laFecha="";
		try(Connection con=ConnectionLocator.getConnection();){
			String sql ="select productos from pedidos order by fecha DESC";
			/*.createStatement 
			es para crear un objeto statement que se utiliza 
			para ejecutar una sentencia SQL en una base de datos.
			Este objeto permite enviar comandos SQL a la base de datos 
			y procesar los resultados obtenidos*/ 
			Statement st=con.createStatement();
			/* variable de tipo Resulset que se utiliza para almacenar los resultados de una consulta SQL.*/
			/*En resumen, esta línea de código ejecuta una consulta SQL y almacena los resultados en un objeto ResultSet llamado rs.*/
			ResultSet rs=st.executeQuery(sql);
			/*es un objeto que contiene el resultado de una consulta SQL 
			 realizada a una base de datos. Este objeto se utiliza para 
			 acceder a los datos devueltos por una consulta SELECT y procesarlos 
			 en una aplicación Java.*/
			rs.next();//nos desplazamos a la primera fila
			laFecha=rs.getString("productos");//te saca la fila entera ordenada
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return laFecha;
	}
}