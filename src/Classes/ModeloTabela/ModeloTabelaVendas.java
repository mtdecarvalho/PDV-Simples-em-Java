/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.ModeloTabela;

import Classes.Venda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juliana
 */
public class ModeloTabelaVendas extends AbstractTableModel {
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_DATA = 1;
    private static final int COLUNA_HORA = 2;
    private static final int COLUNA_PRECO = 3;
    private static final int COLUNA_CLIENTE = 4;
    
    
    private String colunas[] = new String[]{"Código", "Data", "Hora", "Preço", "Cliente"};
    private ArrayList<Venda> vendas;
    
    public ModeloTabelaVendas(ArrayList<Venda> vendas){
        this.vendas = new ArrayList<Venda>(vendas);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return vendas.size();
    }
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    @Override
    public boolean isCellEditable(int linha, int coluna){
        return false;
    }
    @Override
    public Object getValueAt(int linha, int coluna){
        Venda venda = vendas.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                return venda.getCodigo();
            case COLUNA_DATA:
                return venda.getData();
            case COLUNA_HORA:
                return venda.getHora();     
            case COLUNA_PRECO:
                return venda.getPrecoTotal();
            case COLUNA_CLIENTE:
                return venda.getCodigoCliente();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        Venda venda = vendas.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                venda.setCodigo(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_DATA:
                venda.setData(valor.toString());
                break;
            case COLUNA_HORA:
                venda.setHora(valor.toString());
                break;           
            case COLUNA_PRECO:
                venda.setPrecoTotal(Double.parseDouble(valor.toString()));
                break;
            case COLUNA_CLIENTE:
                venda.setCodigoCliente(valor.toString());
                break;
        }
    }
    
    public Venda getVenda(int indice){
        return vendas.get(indice);
    }
    public void inserirVenda(Venda venda){
        vendas.add(venda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarVenda(int indice, Venda venda){
        vendas.set(indice, venda);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirVenda(int indice){
        vendas.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }
}
