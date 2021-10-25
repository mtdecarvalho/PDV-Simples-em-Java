/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Cliente;
import Classes.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
            stmt.setString(5, cliente.getEndereco().getCEP());
            
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
