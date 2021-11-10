/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

/**
 *
 * @author Juliana
 */
import Classes.ConnectionFactory;
import Classes.Parametros;
import Classes.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ItemVendaDAO {
    
    public void create(ItemVenda itemvenda, Parametros parametro)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO itemvenda(codigoProduto, codigoVenda, qtdVendida, preco) VALUES (?,?,?,?)");
            
            stmt.setInt(1, itemvenda.getCodigoProduto());
            stmt.setInt(2, itemvenda.getCodigoVenda());
            stmt.setInt(3, itemvenda.getQtdVendida());            
            stmt.setDouble(4, itemvenda.getPreco());
            
            stmt.executeUpdate();
            
            if ( parametro == Parametros.COM_NOTIFICACAO )
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
    
    public ArrayList<ItemVenda> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<ItemVenda> itens = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM itemvenda");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                ItemVenda itemvenda = new ItemVenda();
                
                itemvenda.setCodigoProduto(rs.getInt("codigoProduto"));
                itemvenda.setCodigoVenda(rs.getInt("codigoVenda"));
                itemvenda.setQtdVendida(rs.getInt("qtdVendida"));               
                itemvenda.setPreco(rs.getDouble("preco"));
                
                itens.add(itemvenda);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itens;
    }
    
    public ArrayList<ItemVenda> read(int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<ItemVenda> itens = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM itemvenda WHERE codigoVenda = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                ProdutoDAO pDAO = new ProdutoDAO();
                ItemVenda itemvenda = new ItemVenda();
                
                itemvenda.setCodigoProduto(rs.getInt("codigoProduto"));
                itemvenda.setCodigoVenda(rs.getInt("codigoVenda"));
                itemvenda.setQtdVendida(rs.getInt("qtdVendida"));               
                itemvenda.setPreco(rs.getDouble("preco"));
                itemvenda.setNome(pDAO.getNome(rs.getInt("codigoProduto")));
                
                itens.add(itemvenda);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itens;
    }
    
    public void delete(ItemVenda itemvenda)
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
