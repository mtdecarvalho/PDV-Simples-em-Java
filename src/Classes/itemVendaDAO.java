/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Juliana
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class itemVendaDAO {
    
    public void create(itemVenda itemvenda)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO itemvenda(codigoProduto, codigoVenda, qtdVendida, preco) VALUES (?,?,?,?)");
            
            stmt.setInt(1, itemvenda.getCodigoProduto());
            stmt.setInt(2, itemvenda.getCodigoVenda());
            stmt.setInt(3, itemvenda.getqtdVendida());            
            stmt.setDouble(4, itemvenda.getPreco());
            
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
    
    public ArrayList<itemVenda> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<itemVenda> itens = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM itemvenda");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                itemVenda itemvenda = new itemVenda();
                
                itemvenda.setCodigoProduto(rs.getInt("codigoProduto"));
                itemvenda.setCodigoVenda(rs.getInt("codigoVenda"));
                itemvenda.setQtdVendida(rs.getInt("qtdVendida"));               
                itemvenda.setPreco(rs.getDouble("preco"));
                
                itens.add(itemvenda);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(itemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itens;
    }
    
    public void update(itemVenda itemvenda, int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("UPDATE itemvenda SET codigoProduto = ? , codigoVenda = ? , "
                    + "qtdVendida = ? , preco = ? WHERE codigoProduto = ?");
            
            stmt.setInt(1, itemvenda.getCodigoProduto());
            stmt.setInt(2, itemvenda.getCodigoVenda());
            stmt.setInt(3, itemvenda.getqtdVendida());            
            stmt.setDouble(4, itemvenda.getPreco());
            stmt.setInt(5, codigo);
            
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
    
    public void delete(itemVenda itemvenda)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("DELETE FROM itemvenda WHERE codigoProduto = ?, codigoVenda = ?");
            
            stmt.setInt(1, itemvenda.getCodigoProduto());
            
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
