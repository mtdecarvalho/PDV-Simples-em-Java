/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Produto;
import Classes.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carvalho
 */
public class ProdutoDAO {
    
    public void create(Produto produto)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO produto(codigo, unidade, qtdEstoque, nome, preco) VALUES (?,?,?,?,?)");
            
            stmt.setInt(1, produto.getCodigo());
            stmt.setInt(2, produto.getUnidade());
            stmt.setInt(3, produto.getQtdEstoque());
            stmt.setString(4, produto.getNome());
            stmt.setDouble(5, produto.getPreco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
    
}
