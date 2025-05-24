package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploDELETE {
    
    static final String URL = "jdbc:mysql://localhost/tienda";
    static final String USUARIO = "root";
    static final String PASS = "";

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        try {
            
            // Estableciendo la conexi�n
            conexion = DriverManager.getConnection(URL, USUARIO, PASS);
            System.out.println("[!]ESTAS CONECTADO");
            String query = "SELECT * FROM clientes";
            //CreateStatement por defecto no es SCROLL ni UPDATE
            Statement querySelect = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultado = querySelect.executeQuery(query);
            
            while(resultado.next()) {
            	//Me posiciono en el registro (fila) que quiero borrar
            	if(resultado.getString("nombre").equals("Raul")) {
            		resultado.deleteRow();
            		System.out.println("Registro borrado");
            	}else {
            	   	System.out.println(resultado.getString("nombre"));
            	}
         
            }
            
            System.out.println("[!]ESTAS DESCONECTADO");
            querySelect.close();
            conexion.close();
            

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            System.out.println("[!]ESTAS DESCONECTADO");
            conexion.close();
        } finally {
            
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexi�n: " + e.getMessage());
                    System.out.println("[!]ESTAS DESCONECTADO");
                    conexion.close();
                }
            }
        }
    }
}
