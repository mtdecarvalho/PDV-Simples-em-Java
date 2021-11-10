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
    private int codigo, telefone, numero;
    private String nome, email, rua, complemento, cidade, UF, CEP;
    
    public int getCodigo()                              { return codigo; }
    public int getTelefone()                            { return telefone; }
    public String getNome()                             { return nome; }
    public String getEmail()                            { return email; }
    public String getRua()                              { return rua; }
    public String getComplemento()                      { return complemento; }
    public String getCidade()                           { return cidade; }
    public String getUF()                               { return UF; }
    public String getCEP()                              { return CEP; }
    public int getNumero()                              { return numero; }
    
    public void setCodigo( int codigo )                 { this.codigo = codigo; }
    public void setTelefone( int telefone )             { this.telefone = telefone; }
    public void setNome( String nome )                  { this.nome = nome; }
    public void setEmail(String email )                 { this.email = email; }
    public void setRua( String rua )                    { this.rua = rua; }
    public void setComplemento ( String complemento )   { this.complemento = complemento; }
    public void setCidade( String cidade )              { this.cidade = cidade; }
    public void setUF( String UF )                      { this.UF = UF; }
    public void setCEP( String CEP )                    { this.CEP = CEP; }
    public void setNumero(int numero)                   { this.numero = numero; }
}
