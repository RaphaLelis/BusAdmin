package conexao;
import java.sql.Connection;
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
                JOptionPane.showMessageDialog(null, "Não conseguimos conectar o banco de dados!");
                throw new SQLException(e.getMessage());
	}
}
}
    

