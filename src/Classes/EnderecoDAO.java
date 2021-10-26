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
public class EnderecoDAO {
    
    public void create(Endereco endereco)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO endereco(CEP, rua, numero, complemento, cidade, UF) VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1, endereco.getCEP());
            stmt.setString(2, endereco.getRua());
            stmt.setInt(3, endereco.getNumero());
            stmt.setString(4, endereco.getComplemento());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getUF());
            
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
        
        public ArrayList<Endereco> read()
        {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            ArrayList<Endereco> enderecos = new ArrayList<>();

            try
            {
                stmt = con.prepareStatement("SELECT * FROM endereco");
                rs = stmt.executeQuery();

                while (rs.next())
                {
                    Endereco endereco = new Endereco();
                    
                    endereco.setCEP(rs.getString("CEP"));
                    endereco.setRua(rs.getString("rua"));
                    endereco.setNumero(rs.getInt("numero"));
                    endereco.setComplemento(rs.getString("complemento"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setUF(rs.getString("UF"));

                    enderecos.add(endereco);
                }

            }
            catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }

            return enderecos;
        }
    
        public void update(Endereco endereco, String CEP)
        {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null; 

            try 
            {
                stmt = con.prepareStatement("UPDATE endereco SET CEP = ? , "
                        + "rua = ? , numero = ? , complemento = ? , "
                        + "cidade = ? , UF = ? WHERE CEP = ?");

                stmt.setString(1, endereco.getCEP());
                stmt.setString(2, endereco.getRua());
                stmt.setInt(3, endereco.getNumero());
                stmt.setString(4, endereco.getComplemento());
                stmt.setString(5, endereco.getCidade());
                stmt.setString(6, endereco.getUF());
                stmt.setString(7, CEP);

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
