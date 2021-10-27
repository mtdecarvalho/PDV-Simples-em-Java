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
        EnderecoDAO eDAO = new EnderecoDAO();
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO endereco(CEP, rua, numero, complemento, cidade, UF) VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1, cliente.getEndereco().getCEP());
            stmt.setString(2, cliente.getEndereco().getRua());
            stmt.setInt(3, cliente.getEndereco().getNumero());
            stmt.setString(4, cliente.getEndereco().getComplemento());
            stmt.setString(5, cliente.getEndereco().getCidade());
            stmt.setString(6, cliente.getEndereco().getUF());
            
            stmt.executeUpdate();
            
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
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex);
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
            stmt = con.prepareStatement("SELECT c.*, e.rua, e.numero, e.complemento, e.cidade, e.UF"
                    + " FROM cliente as c, endereco as e WHERE c.CEP = e.CEP");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Cliente cliente = new Cliente();
                Endereco endereco = new Endereco();
                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setTelefone(rs.getInt("telefone"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                endereco.setCEP(rs.getString("CEP"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUF(rs.getString("UF"));
                cliente.setEndereco(endereco);
                
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
    
    public void update(Cliente cliente, String CEP, int codigo)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("UPDATE endereco SET CEP = ?, rua = ? , "
                    + "numero = ? , complemento = ? , cidade = ? , UF = ? WHERE CEP = ?");
            
            stmt.setString(1, cliente.getEndereco().getCEP());
            stmt.setString(2, cliente.getEndereco().getRua());
            stmt.setInt(3, cliente.getEndereco().getNumero());
            stmt.setString(4, cliente.getEndereco().getComplemento());
            stmt.setString(5, cliente.getEndereco().getCidade());
            stmt.setString(6, cliente.getEndereco().getUF());
            stmt.setString(7, CEP);
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE cliente SET codigo = ? , telefone = ? , "
                    + "nome = ? , email = ? , CEP = ? WHERE codigo = ?");
            
            stmt.setInt(1, cliente.getCodigo());
            stmt.setInt(2, cliente.getTelefone());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco().getCEP());
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
    
    public void delete(Cliente cliente)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            
            
            stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
            
            stmt.setInt(1, cliente.getCodigo());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("DELETE FROM endereco WHERE CEP = ?");
            
            stmt.setString(1, cliente.getEndereco().getCEP());
            
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
