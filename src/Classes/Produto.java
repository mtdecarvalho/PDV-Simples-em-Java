package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carvalho
 */
public class Produto {
    private int codigo, unidade, qtdEstoque;
    private String nome, ultimaVenda;
    private double preco;
    
    public int getCodigo()                                  { return codigo; }
    public int getUnidade()                                 { return unidade; }
    public int getQtdEstoque()                              { return qtdEstoque; } 
    public String getNome()                                 { return nome; }
    public String getUltimaVenda()                          { return ultimaVenda; }
    public double getPreco()                                { return preco; }
    
    public void setCodigo( int codigo )                     { this.codigo = codigo; }
    public void setUnidade( int unidade )                   { this.unidade = unidade; }
    public void setQtdEstoque( int qtdEstoque)              { this.qtdEstoque = qtdEstoque; } 
    public void setNome( String nome )                      { this.nome = nome; }
    public void setUltimaVenda( String ultimaVenda)         { this.ultimaVenda = ultimaVenda; }
    public void setPreco( double preco )                    { this.preco = preco; }
    
}
