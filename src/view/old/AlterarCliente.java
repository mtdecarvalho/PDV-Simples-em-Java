package view.old;

import Classes.Cliente;
import Classes.Endereco;
import Classes.Parametros;
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
    private String CEP;
    private int cod;
    private Parametros parametro;
    
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
    
//    public AlterarCliente(java.awt.Frame parent, Parametro op, Cliente c){
//        super(parent, true);
//        initComponents();
//        this.parametro = op;
//        tbxCodigo.setText(String.valueOf(c.getCodigo()));
//        tbxNome.setText(c.getNome());
//        tbxTelefone.setText(String.valueOf(c.getTelefone()));
//        tbxEmail.setText(c.getEmail());
//        tbxCEP.setText(c.getEndereco().getCEP());
//        tbxRua.setText(c.getEndereco().getRua());
//        tbxNumero.setText(String.valueOf(c.getEndereco().getNumero()));
//        tbxComplemento.setText(c.getEndereco().getComplemento());
//        for ( int i = 0 ; i < cbUF.getItemCount() ; i++ )
//        {
//            if ( cbUF.getItemAt(i).contains(c.getEndereco().getUF()) )
//            {
//                cbUF.setSelectedIndex(i);
//                break;
//            }
//        }
//        tbxCidade.setText(c.getEndereco().getCidade());
//        
//        
//    }
    
    public AlterarCliente(java.awt.Frame parent, Parametros op, Cliente c, int indice){
        super(parent, true);
        this.parametro = op;
        this.indice = indice;
        this.CEP = c.getEndereco().getCEP();
        this.cod = c.getCodigo();
        initComponents();
        tbxCodigo.setText(String.valueOf(c.getCodigo()));
        tbxNome.setText(c.getNome());
        tbxTelefone.setText(String.valueOf(c.getTelefone()));
        tbxEmail.setText(c.getEmail());
        tbxCEP.setText(c.getEndereco().getCEP());
        tbxRua.setText(c.getEndereco().getRua());
        tbxNumero.setText(String.valueOf(c.getEndereco().getNumero()));
        tbxComplemento.setText(c.getEndereco().getComplemento());
        for ( int i = 0 ; i < cbUF.getItemCount() ; i++ )
        {
            if ( cbUF.getItemAt(i).contains(c.getEndereco().getUF()) )
            {
                cbUF.setSelectedIndex(i);
                break;
            }
        }
        tbxCidade.setText(c.getEndereco().getCidade());
        
        if ( parametro == Parametros.CONSULTAR )
        {
            tbxCodigo.setEditable(false);
            tbxNome.setEditable(false);
            tbxTelefone.setEditable(false);
            tbxEmail.setEditable(false);
            tbxCEP.setEditable(false);
            tbxRua.setEditable(false);
            tbxNumero.setEditable(false);
            tbxComplemento.setEditable(false);
            cbUF.setEditable(false);
            tbxCidade.setEditable(false);
        }
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
        tbxCEP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tbxRua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tbxCodigo = new javax.swing.JTextField();
        tbxNome = new javax.swing.JTextField();
        tbxTelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tbxNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbxComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tbxCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbUF = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pessoa Física");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Codigo:");

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("CEP:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Rua:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Numero:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Complemento:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Cidade:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("UF:");

        cbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbxNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tbxCodigo)
                                        .addComponent(tbxNome)
                                        .addComponent(tbxTelefone)
                                        .addComponent(tbxEmail)
                                        .addComponent(tbxCEP)
                                        .addComponent(tbxRua, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbxComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbxCidade)))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tbxCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tbxRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(tbxComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if ( parametro == Parametros.ALTERAR )
        {
            Cliente cliente = new Cliente();
            Endereco endereco = new Endereco();

            ClienteDAO daoC = new ClienteDAO();

            cliente.setCodigo(Integer.parseInt(tbxCodigo.getText()));
            cliente.setNome(tbxNome.getText());
            cliente.setTelefone(Integer.parseInt(tbxTelefone.getText()));
            cliente.setEmail(tbxEmail.getText());
            endereco.setCEP(tbxCEP.getText());
            endereco.setRua(tbxRua.getText());
            endereco.setNumero(Integer.parseInt(tbxNumero.getText()));
            endereco.setComplemento(tbxComplemento.getText());
            endereco.setCidade(tbxCidade.getText());
            endereco.setUF(cbUF.getSelectedItem().toString());
            cliente.setEndereco(endereco);

            daoC.update(cliente, CEP, cod);
        }
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
    private javax.swing.JComboBox<String> cbUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tbxCEP;
    private javax.swing.JTextField tbxCidade;
    private javax.swing.JTextField tbxCodigo;
    private javax.swing.JTextField tbxComplemento;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxNumero;
    private javax.swing.JTextField tbxRua;
    private javax.swing.JTextField tbxTelefone;
    // End of variables declaration//GEN-END:variables
}
