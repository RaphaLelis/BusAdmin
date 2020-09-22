package conexao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Rapha
 */
public class conexaobd {
    public static Connection getConnection() throws SQLException{
        
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		JOptionPane.showMessageDialog(null, "Conectado ao Banco de Dados");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
                
	}
        catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados!");
                throw new SQLException(e.getMessage());
	}
    }
    
     public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexaobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst) {

        closeConnection(con);

        try {

            if (pst != null) {
                pst.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexaobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {

        closeConnection(con, pst);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexaobd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

