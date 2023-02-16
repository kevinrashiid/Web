package serviceLibros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Tema;
import service.locator.ConnectionLocator;

public class LibrosServiceIMPL implements LibrosService{
	
	
	public List<Libro> listaDeLibros() {
		List<Libro> libros= new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from libros";
			PreparedStatement ps=con.prepareStatement(sql); //Lanzar consultas a la base de datos
			ResultSet rs=ps.executeQuery(); //forwardonly
			while(rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"), 
										rs.getString("titulo"),
										rs.getString("autor"), 
										rs.getDouble("precio"),
										rs.getInt("paginas"),
										rs.getInt("Tema")));			
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
	}
	public List<Tema> listaDeIdTema(){
		List<Tema> Tema=new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from temas";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tema.add(new Tema(rs.getInt("idTema"),
									rs.getString("tematica")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Tema;
	}
	@Override
	public List<Libro> librosPorTemas(int idTema) {
		List<Libro> listaDeLibrosPorTema=new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from libros where idTema=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idTema);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				listaDeLibrosPorTema.add(new Libro(rs.getInt("isbn"), 
										rs.getString("titulo"),
										rs.getString("autor"), 
										rs.getDouble("precio"),
										rs.getInt("paginas"),
										rs.getInt("Tema")));			
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listaDeLibrosPorTema;
	}
}