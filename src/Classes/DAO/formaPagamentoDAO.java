/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

import Classes.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
}
