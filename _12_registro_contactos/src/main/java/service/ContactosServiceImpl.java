package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contacto;
import service.locator.ConnectionLocator;

public class ContactosServiceImpl implements ContactosService {	
	@Override
	public void agregarContacto(Contacto contacto) {
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
