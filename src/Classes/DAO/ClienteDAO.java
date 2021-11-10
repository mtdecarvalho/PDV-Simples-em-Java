/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DAO;

import Classes.Cliente;
import Classes.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carvalho
 */
public class ClienteDAO {
    
    public void create(Cliente cliente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmtEndereco = null;
        
        try 
        {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("INSERT INTO cliente(codigo, telefone, nome, email, CEP, rua, numero, complemento, cidade, UF)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setInt(1, cliente.getCodigo());
            stmt.setInt(2, cliente.getTelefone());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCEP());
            stmt.setString(6, cliente.getRua());
            stmt.setInt(7, cliente.getNumero());
            stmt.setString(8, cliente.getComplemento());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getUF());
            
            stmt.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Cliente> read()
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setTelefone(rs.getInt("telefone"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCEP(rs.getString("CEP"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUF(rs.getString("UF"));
                
                clientes.add(cliente);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    public void update(Cliente cliente, int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("UPDATE cliente SET telefone = ? , "
                    + "nome = ? , email = ? , CEP = ?, rua = ?, numero = ? , complemento = ? "
                    + ", cidade = ? , UF = ? WHERE codigo = ?");
            
            stmt.setInt(1, cliente.getTelefone());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCEP());
            stmt.setString(5, cliente.getRua());
            stmt.setInt(6, cliente.getNumero());
            stmt.setString(7, cliente.getComplemento());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getUF());
            stmt.setInt(10, codigo);
            
            stmt.executeUpdate();           
            con.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Cliente cliente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            
            con.setAutoCommit(false);
            stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
            
            stmt.setInt(1, cliente.getCodigo());
            
            stmt.executeUpdate();
            
            con.commit();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            if (con != null){
                try {
                   JOptionPane.showMessageDialog(null, "Transaction is being rolled back.");
                   con.rollback();
                } catch (SQLException excep) {
                    JOptionPane.showMessageDialog(null, excep);
                }
            }
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public String getNome(int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = null;
        
        try
        {
            stmt = con.prepareStatement("SELECT nome FROM cliente WHERE codigo = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                nome = rs.getString("nome");
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return nome;
    }
    
}
