package view;

import Classes.Parametros;
import Classes.Produto;
import javax.swing.JOptionPane;
import Classes.DAO.ProdutoDAO;
import java.awt.Dimension;
/**
 *
 * @author Carvalho
 */
public class ModificarProduto extends javax.swing.JDialog {
    private Parametros param;
    private boolean confirmado;
    private int cod;
    
    public static boolean executar(java.awt.Frame parent, Parametros param, Produto produto)
    {
        ModificarProduto modificar = new ModificarProduto(parent, param, produto);
        modificar.setLocationRelativeTo(null);
        modificar.setVisible(true);
        
        return modificar.paramConfirmado();
    }
    
    public boolean paramConfirmado()
    {
        return confirmado;
    }
    
    public ModificarProduto(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public ModificarProduto(java.awt.Frame parent, Parametros param, Produto p)
    {
        super(parent, true);
        confirmado = false;
        this.param = param;
        this.cod = p.getCodigo();
        initComponents();

        lblCodigo.setVisible(false);
        tbxCodigo.setVisible(false);
        lblUltimaVenda.setVisible(false);
        tbxUltimaVenda.setVisible(false);
        tbxUltimaVenda.setEditable(false);
        if ( param == Parametros.ALTERAR || param == Parametros.CONSULTAR )
        {
            tbxNome.setText(p.getNome());
            tbxQtdEstoque.setText(String.valueOf(p.getQtdEstoque()));
            for ( int i = 0 ; i < cbUnidade.getItemCount() ; i++ )
            {
                if ( cbUnidade.getItemAt(i).contains(p.getUnidade()))
                {
                    cbUnidade.setSelectedIndex(i);
                    break;
                }
            }
            tbxPreco.setText(String.valueOf(p.getPreco()));  
            if ( param == Parametros.CONSULTAR )
            {
                lblCodigo.setVisible(true);
                tbxCodigo.setVisible(true);
                tbxCodigo.setText(String.valueOf(p.getCodigo()));
                tbxNome.setEditable(false);
                tbxQtdEstoque.setEditable(false);
                cbUnidade.setEnabled(false);
                tbxPreco.setEditable(false);
                lblUltimaVenda.setVisible(true);
                tbxUltimaVenda.setVisible(true);
                tbxUltimaVenda.setText(p.getUltimaVenda());
                tbxUltimaVenda.setEditable(false);
                btnCancelar.setVisible(false);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbxPreco = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        tbxUltimaVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblUltimaVenda = new javax.swing.JLabel();
        tbxCodigo = new javax.swing.JTextField();
        tbxNome = new javax.swing.JTextField();
        tbxQtdEstoque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCodigo.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Produto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Qtd. em estoque:");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Unidade:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Preço:");

        lblUltimaVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUltimaVenda.setText("Última Venda:");

        tbxCodigo.setEditable(false);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produtos.png"))); // NOI18N

        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grama (g)", "Kilograma (kg)", "Mililitro (ml)", "Litro (L)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUltimaVenda)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(lblCodigo))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(tbxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(tbxQtdEstoque)
                            .addComponent(tbxCodigo)
                            .addComponent(tbxPreco)
                            .addComponent(tbxUltimaVenda)
                            .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(tbxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tbxQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tbxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUltimaVenda)
                    .addComponent(tbxUltimaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        switch (param)
        {
            case ADICIONAR:
                produto.setNome(tbxNome.getText());
                produto.setQtdEstoque(Integer.parseInt(tbxQtdEstoque.getText()));
                switch (cbUnidade.getSelectedItem().toString())
                {
                    case "Grama (g)":
                        produto.setUnidade("g");
                        break;
                    case "Kilograma (kg)":
                        produto.setUnidade("kg");
                        break;
                    case "Mililitro (ml)":
                        produto.setUnidade("ml");
                        break;
                    case "Litro (L)":
                        produto.setUnidade("L");
                        break;
                    default:
                        produto.setUnidade("");
                        break;
                }
                produto.setPreco(Double.parseDouble(tbxPreco.getText()));
                dao.create(produto);
                break;
            case ALTERAR:
                produto.setNome(tbxNome.getText());
                produto.setQtdEstoque(Integer.parseInt(tbxQtdEstoque.getText()));
                switch (cbUnidade.getSelectedItem().toString())
                {
                    case "Grama (g)":
                        produto.setUnidade("g");
                        break;
                    case "Kilograma (kg)":
                        produto.setUnidade("kg");
                        break;
                    case "Mililitro (ml)":
                        produto.setUnidade("ml");
                        break;
                    case "Litro (L)":
                        produto.setUnidade("L");
                        break;
                    default:
                        produto.setUnidade("");
                        break;
                }
                produto.setPreco(Double.parseDouble(tbxPreco.getText()));

                dao.update(produto, cod);
                break;
        }
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja cancelar o cadastro?", "Confirmação", 2) == 0){
            dispose();
        }
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
            java.util.logging.Logger.getLogger(ModificarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                ModificarProduto dialog = new ModificarProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbUnidade;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblUltimaVenda;
    private javax.swing.JTextField tbxCodigo;
    private javax.swing.JTextField tbxNome;
    private javax.swing.JTextField tbxPreco;
    private javax.swing.JTextField tbxQtdEstoque;
    private javax.swing.JTextField tbxUltimaVenda;
    // End of variables declaration//GEN-END:variables
}
