package bdescuela;

import java.sql.*;
import javax.swing.JOptionPane;
//import com.mysql.cj.jdbc.Driver;
import com.mysql.jdbc.Driver;

public class Conectar {

    Connection con = null;
    
    public Connection conexion() {
        
        try {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "root", "");
            
            System.out.println("Conexión realizada");

            
        }catch(Exception e){
        
            System.out.println("No conectado "+e);
            
        }
        
        return con;
        
    }
    
}
