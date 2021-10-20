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
public class Endereco {
    private String rua, complemento, cidade, UF, CEP;
    private int numero;
    
    public String getRua()                              { return rua; }
    public String getComplemento()                      { return complemento; }
    public String getCidade()                           { return cidade; }
    public String getUF()                               { return UF; }
    public String getCEP()                              { return CEP; }
    public int getNumero()                              { return numero; }
    
    public void setRua( String rua )                    { this.rua = rua; }
    public void setComplemento ( String complemento )   { this.complemento = complemento; }
    public void setCidade( String cidade )              { this.cidade = cidade; }
    public void setUF( String UF )                      { this.UF = UF; }
    public void setCEP( String CEP )                    { this.CEP = CEP; }
    public void setNumero(int numero)                   { this.numero = numero; }
    
}
