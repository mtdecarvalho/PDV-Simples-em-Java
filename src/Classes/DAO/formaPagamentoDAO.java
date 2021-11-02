/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

import Classes.ConnectionFactory;
import Classes.FormaPagamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Carvalho
 */
public class formaPagamentoDAO {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null; 
    ResultSet rs = null;
    
    public void updateValorTotal(int codigo, double valor)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        double valorNovo = 0;
        
        try 
        {
            stmt = con.prepareStatement("SELECT valorTotal FROM formadepagamento WHERE codigo = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                valorNovo = rs.getDouble("valorTotal");
            }
            valorNovo = valorNovo + valor;
            
            stmt = con.prepareStatement("UPDATE formadepagamento SET valorTotal = ? WHERE codigo = ?");
            
            stmt.setDouble(1, valorNovo);
            stmt.setInt(2, codigo);
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<FormaPagamento> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<FormaPagamento> pagamentos = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM formadepagamento");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                FormaPagamento pagamento = new FormaPagamento();
                
                pagamento.setCodigo(rs.getInt("codigo"));
                pagamento.setNome(rs.getString("nome"));
                pagamento.setValorTotal(rs.getDouble("valorTotal"));
                
                pagamentos.add(pagamento);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return pagamentos;
    }
}
