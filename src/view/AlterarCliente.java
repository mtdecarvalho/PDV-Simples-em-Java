package view;

import Classes.Cliente;
import javax.swing.JOptionPane;
import Classes.ClienteDAO;
/**
 *
 * @author Carvalho
 */
public class AlterarCliente extends javax.swing.JDialog {
//    private opcCadastro opc;
//    private ClientePF pfAlterado;
    private boolean confirmado;
    private int indice;
    private int cod;
    
//    public static boolean executar(java.awt.Frame parent, opcCadastro opc, ClientePF pf, int i){
//        CadastrarCliente cadastrar = new CadastrarCliente(parent, opc, pf, i);
//        cadastrar.setLocationRelativeTo(null);
//        cadastrar.setVisible(true);
//        return cadastrar.opcConfirmada();
//    }
    
    public AlterarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public AlterarCliente(java.awt.Frame parent, Cliente c, int i, int cod){
        super(parent, true);
        this.indice = i;
        this.cod = cod;
        initComponents();
        tbxNome.setText(c.getNome());
        tbxTelefone.setText(String.valueOf(c.getTelefone()));
        tbxEmail.setText(c.getEmail());
    }
    
//    public CadastrarCliente(java.awt.Frame parent, opcCadastro opc, ClientePF pf, int i){
//        super(parent, true);
//        confirmado = false;
//        this.opc = opc;
//        pfAlterado = pf;
//        this.indice = i;
//        initComponents();
//        if(opc == opc.ocAlterar){
//            tbxCodigo.setText(pf.getNome());
//            tbxNome.setText(pf.getCPF());
//            tbxTelefone.setText(pf.getTelefone());
//            tbxEmail.setText(pf.getTelComercial());
//            tbxCEP.setText(pf.getTelCel());
//            tbxRua.setText(pf.getFAX());
//        }    
//    }
    
    public boolean opcConfirmada(){
        return confirmado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbxEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        tbxNome = new javax.swing.JTextField();
        tbxTelefone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pessoa Física");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Cliente");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Telefone:");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(162, 162, 162))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(tbxTelefone)
                    .addComponent(tbxEmail))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tbxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        Cliente cliente = new Cliente();
        
        ClienteDAO dao = new ClienteDAO();
        
        cliente.setNome(tbxNome.getText());
        cliente.setTelefone(Integer.parseInt(tbxTelefone.getText()));
        cliente.setEmail(tbxEmail.getText());
        
        dao.updatePessoal(cliente);
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Cancelar cadastro?") == 0)
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlterarCliente dialog = new AlterarCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxTelefone;
    // End of variables declaration//GEN-END:variables
}
