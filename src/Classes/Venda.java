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
public class Venda {
    private int codigo, codigoCliente, formaDePagamento;
    private String data, hora;
    private double precoTotal;
    
//    private Cliente cliente
    
    public int getCodigo()                          { return codigo; }
    public String getData()                         { return data; }
    public String getHora()                         { return hora; }
    public double getPrecoTotal()                   { return precoTotal; }
//    public Cliente getCliente()                     { return cliente; }
    public int getCodigoCliente()                   { return codigoCliente; }
    public int getFormaPagamento()                  { return formaDePagamento; }
    
    public void setData( String data )              { this.data = data; }
    public void setHora( String hora )              { this.hora = hora; }
    public void setPrecoTotal( double precoTotal )  { this.precoTotal = precoTotal; }
//    public void setCliente( Cliente cliente )       { this.cliente = cliente; }
    public void setCodigo(int codigo)               {this.codigo = codigo;}
    public void setCodigoCliente(int codigoCliente) { this.codigoCliente = codigoCliente; }
    public void setFormaPagamento( int formaDePagamento ) { this.formaDePagamento = formaDePagamento; }
}
