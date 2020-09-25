package model.dao;
import conexao.conexaobd;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Usuarios;
import telas.Login;
/**
 *
 * @author Rapha
 */
public class UsuarioDAO {
    
    public boolean checkLogin(String email, String senha) throws SQLException {

        Connection con = conexaobd.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean check = false;
        try {
            
            pst = con.prepareStatement("SELECT email, senha FROM cadastro WHERE email=? and senha=?");
            pst.setString(1, email);
            pst.setString(2, senha);

            rs = pst.executeQuery();

            if (rs.next()) {
              
                check = true;
            }
            else{
                pst.close();
                return check;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
         
    }
    
}
