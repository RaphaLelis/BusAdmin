package model.dao;
import conexao.conexaobd;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rapha
 */
public class usuarioDAO {
    
    public boolean checkLogin(String email, String senha) throws SQLException {

        Connection con = conexaobd.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            pst = con.prepareStatement("SELECT * FROM cadastro WHERE email = ? and senha = ?");
            pst.setString(1, email);
            pst.setString(2, senha);

            rs = pst.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexaobd.closeConnection(con, pst, rs);
        }

        return check;

    }
    
}
