/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Carvalho
 */
public class Venda {
    private int codigo;
    private String data, hora;
    private double valor;
    private Cliente cliente;
    private ArrayList<itemVenda> itens;
    
    public String getData()                         { return data; }
    public String getHora()                         { return hora; }
    public double getValor()                        { return valor; }
    public Cliente getCliente()                     { return cliente; }
    
    public void setData( String data )              { this.data = data; }
    public void setHota( String hora )              { this.hora = hora; }
    public void setValor( double valor )            { this.valor = valor; }
    public void setCliente( Cliente cliente )       { this.cliente = cliente; }
}
