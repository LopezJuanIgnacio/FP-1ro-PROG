import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploSELECT {
    
    static final String URL = "jdbc:mysql://localhost/ciclismo";
    static final String USUARIO = "root";
    static final String CONTRASE�A = "ender";

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        try {
            
            // Estableciendo la conexi�n
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASE�A);
            System.out.println("[!]ESTAS CONECTADO");
            //String query con SQL correcto
            String query = "SELECT * FROM equipo";
            //Conexi�n define el Statement especificando si es SCROLL_SENSITIVE o CONCUR_UPDATABLE
            Statement querySelect = conexion.createStatement();
            //Se ejecuta la query guardando el resultado en un ResultSet
            ResultSet resultado = querySelect.executeQuery(query);
            
            while(resultado.next()) {
            	System.out.println(resultado.getString("nomeq"));
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
