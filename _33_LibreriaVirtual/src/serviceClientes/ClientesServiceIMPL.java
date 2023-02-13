package serviceClientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.locator.ConnectionLocator;

public class ClientesServiceIMPL implements ClientesService {
	
	//metodo que te dice si un contacto existe en un Base de datos en SQL
	@Override
	public boolean existeContacto(String usuario,String pwd) {
		boolean existe;
		try(Connection con=ConnectionLocator.getConnection();){
			
			String sql="Select * from clientes where usuario=? and password=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, usuario);
			st.setString(2, pwd);
			ResultSet rs=st.executeQuery();
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}