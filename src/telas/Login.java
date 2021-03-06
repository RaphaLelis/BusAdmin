package telas;
import javax.swing.JOptionPane;
import conexao.conexaobd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.UsuarioDAO;
import java.sql.Connection;
import telas.Cadastro;


/**
 *
 * @author Rapha
 */
public class Login extends javax.swing.JFrame {
    
    public String Acesso;//Variavel global para armazenaro o acesso do login
    
        

    public Login() {
        initComponents();
        

    }
    
    //Método para limpar os campos após o cadastro!
    public void limpar(){
        txtemail2.setText("");
        txtsenha2.setText("");
        
    }
   
    
    public boolean checkLogin(String email, String senha){
        return email.equals(txtemail2.getText()) && senha.equals(txtsenha2.getText());
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        btnlogin = new javax.swing.JButton();
        btncadastro = new javax.swing.JButton();
        lblemail = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        txtemail2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtsenha2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 200));

        btnlogin.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btncadastro.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btncadastro.setText("Cadastro");
        btncadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastroActionPerformed(evt);
            }
        });

        lblemail.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        lblemail.setText("E-mail:");

        lblsenha.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        lblsenha.setText("Senha:");

        txtemail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemail2ActionPerformed(evt);
            }
        });

        jLabel1.setText("BusAdmin LTDA - 2020");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busadmin.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblsenha)
                            .addComponent(lblemail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtemail2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(txtsenha2)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail)
                    .addComponent(txtemail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsenha)
                    .addComponent(txtsenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnlogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncadastro)
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtemail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemail2ActionPerformed

    //Botão de LOGIN / checklogin!!!
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
                    
        try{
           
           Connection con = conexaobd.getConnection(); 
           conexaobd conn = new conexaobd(con);
           String senha = txtsenha2.getText();
           
           
           conn.executeSQL("select * from cadastro where email='" +txtemail2.getText()+"'");
           conn.rs.first();

           if(conn.rs.getString("senha").equals(senha)){  
               JOptionPane.showMessageDialog(null, "Bem vindo Sr." + conn.rs.getString("nome")+ " "+ conn.rs.getString("sobrenome")+"!");
               Principal frame = new Principal();
               frame.setVisible(true);
               dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, "Senha incorreta!");
           }
               
            
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(rootPane, "Usuário não cadastrado! Favor fazer o cadastro..." + ex);
           Cadastro frame = new Cadastro();
           frame.setVisible(true);
        }
            
    }//GEN-LAST:event_btnloginActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        Cadastro frame = new Cadastro();
        frame.setVisible(true);
    }//GEN-LAST:event_btncadastroActionPerformed

    // MAIN!!!!
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            System.err.println(ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btnlogin;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JTextField txtemail2;
    private javax.swing.JPasswordField txtsenha2;
    // End of variables declaration//GEN-END:variables
}
