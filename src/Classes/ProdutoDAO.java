/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public ArrayList<Produto> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Produto produto = new Produto();
                
                produto.setCodigo(rs.getInt("codigo"));
                produto.setUnidade(rs.getInt("unidade"));
                produto.setQtdEstoque(rs.getInt("qtdEstoque"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setUltimaVenda(rs.getString("ultimaVenda"));
                
                produtos.add(produto);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public void update(Produto produto, int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("UPDATE produto SET codigo = ? , unidade = ? , "
                    + "qtdEstoque = ? , nome = ? , preco = ? WHERE codigo = ?");
            
            stmt.setInt(1, produto.getCodigo());
            stmt.setInt(2, produto.getUnidade());
            stmt.setInt(3, produto.getQtdEstoque());
            stmt.setString(4, produto.getNome());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, codigo);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
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
    
    public void delete(Produto produto)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("DELETE FROM produto WHERE codigo = ?");
            
            stmt.setInt(1, produto.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
