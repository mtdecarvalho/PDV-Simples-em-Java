/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Carvalho
 */
public class Cliente {
    private int codigo, telefone;
    private String nome, email, CEP;
    
    public int getCodigo()                          { return codigo; }
    public int getTelefone()                        { return telefone; }
    public String getNome()                         { return nome; }
    public String getEmail()                        { return email; }
    public String getCEP()                          { return CEP;   } 
    
    public void setCodigo( int codigo )             { this.codigo = codigo; }
    public void setTelefone( int telefone )         { this.telefone = telefone; }
    public void setNome( String nome )              { this.nome = nome; }
    public void setEmail(String email )             { this.email = email; }
    public void setCEP(String CEP)                  { this.CEP = CEP; }
}
