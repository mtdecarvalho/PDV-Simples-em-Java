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
public class ItemVenda {
    private int codigoProduto, qtdVendida, codigoVenda;
    private double preco;
    private String nome;
    
    
    public int getCodigoProduto()                           { return codigoProduto; }
    public double getPreco()                                { return preco; }  
    public int getQtdVendida()                              { return qtdVendida; }
    public int getCodigoVenda()                             { return codigoVenda; }
    public String getNome()                                 { return nome; }
    
    public void setCodigoProduto( int codigo )              { this. codigoProduto = codigo; }
    public void setQtdVendida( int qtdVendida )             { this.qtdVendida = qtdVendida; }
    public void setPreco( double preco )                    { this.preco = preco; }
    public void setCodigoVenda( int codigoVenda )           { this.codigoVenda = codigoVenda; }
    public void setNome( String nome )                      { this.nome = nome; }    
}
