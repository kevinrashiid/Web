package Principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserccionContacto {

	public static void main(String[] args) {

		// paso 1: Establecer conexión a la bbdd 
		/*String cadenaCon = "jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd= "root";
		//como se establece conexion con base de datos
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
		//Envio de instruccion SQL
		String sql="insert into contactos(nombre,email,edad) values(´irene´,´pruebas@gmail.com´,19)";
		//objeto para envio de instruccion SQL
		Statement st=con.createStatement();
		//Este ejecuta las dirreciones SQL
		st.execute(sql);
		System.out.println("Contacto añadido!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//cerrar conexion
		//con.close();*/
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="ROOT";
		//Establecer conexión con base de datos
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			//Envío de instrucción SQL
			String sql="insert into contactos(nombre,email,edad) values('Irene','pruebas@gmail.com',19)";
			Statement st=con.createStatement(); //objeto para envío de instrucción SQL
			st.execute(sql); //envío de instrucción
			System.out.println("contacto añadido!");
		}//cerrar conexión
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
