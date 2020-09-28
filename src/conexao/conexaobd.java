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
    
    private Connection con;
    public Statement pst;
    public ResultSet rs;
    
    public conexaobd(Connection con){
        this.con = con; 
    }
    
    public static Connection getConnection() throws SQLException{
        //SET GLOBAL time_zone = '+3:00';
        
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
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
    
    //METODO EXECUTA SQL
    public void executeSQL(String sql){
        try{//Statement navegavel
            pst = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);//CAMINHO DA CONEXÃO (settar todos os dados)
            rs = pst.executeQuery(sql);// SQL QUE SERA EXECUTADO
        }
        catch(SQLException sqlex){
            JOptionPane.showConfirmDialog(null,"Não foi possivel"+
                    " executar o Comando SQL, "+sqlex+", o sql passado foi o.: "+sql);
        }
    }
}
    

