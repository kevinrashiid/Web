package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.pedidos;
import service.locator.ConnectionLocator;

//String ruta="C:\\TufKevin\\Eclipse\\Ficheros"
public class PedidosTiendasServiceIMPL implements PedidosTiendasService {

	@Override
	public List<pedidos> pedidosTienda(String dirFichero) {
		Path pr=Path.of(dirFichero);
		try {
		return Files.lines(pr)//Stram<String>
		.map(s->{
			String[] datos=s.split("[,]");
			return new pedidos(0,datos[0],Integer.parseInt(datos[1]),LocalDate.parse(datos[2]))})
				.toList();
		}
		catch(IOException e) {
			e.printStackTrace();
			return List.of();
		}
	}

	@Override
	public void guardarPedido(pedidos pedido) {
		try(Connection con=ConnectionLocator.getConnection()){
			String sql="inset into pedidos(producto,unidade,fecha)values(?,?,?)";
			//por que no sabemos los datos y utilizamos ?,?,?
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

	@Override
	public void guardarPedidos(List<pedidos> pedidoS) {
		try(Connection con=ConnectionLocator.getConnection();){
			//desactivamos autocomint para que todos los insert esten en la misma tx
			con.setAutoCommit(false);
			String sql="inset into pedidoS(producto,unidade,fecha)values(?,?,?)";
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
}