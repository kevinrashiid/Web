package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EliminarContacto {

	public static void main(String[] args) {
		//pide por teclado la introduccion de un nombre y elimina 
		//el contacto con dicho nombre
		
		Scanner sc=new Scanner(System.in);
		System.err.println("Introduce el nombre del contacto que quieres eliminar");
		String nombre=sc.nextLine();
		//el acceso a datos
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="ROOT";
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			//VERSION Statement
			//elimina el contacto con dicho nombre
			/*String sql="delete from contactos where nombre='"+nombre+"'";
			Statement st=con.createStatement();
			st.execute(sql);*/
			
			//VERSION PreparedStatement
			//otra alternativa: intrucciones SQl parametrizada
			//se le llamada asi donde los valores desconocidos 
			//se indican mediante parametros
			//es decir lo valores desconocidos se indican con el ?
			//en algun momento hay que darle valor a esa ?
			String sql="delete from contactos where nombre=?";
			//sustituit parametros por sus valores
			PreparedStatement ps=con.prepareStatement(sql);
			//àl parametro 1 asignale lo que hemos introducido con scanner
			ps.setString(1, nombre);
			//ejecucion de la consulta
			ps.execute();
			System.out.println("Contacto eliminado");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}