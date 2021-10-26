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
            stmt = con.prepareStatement("INSERT INTO cliente(codigo, telefone, nome, email, CEP) VALUES (?,?,?,?,?)");
            
            stmt.setInt(1, cliente.getCodigo());
            stmt.setInt(2, cliente.getTelefone());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCEP());
            
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
    
    public void updatePessoal(Cliente cliente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("UPDATE cliente SET telefone = ? , "
                    + "nome = ? , email = ? , CEP = ? WHERE codigo = ?");
            
            stmt.setInt(1, cliente.getTelefone());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCEP());
            stmt.setInt(4, cliente.getCodigo());
            
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
    
}
