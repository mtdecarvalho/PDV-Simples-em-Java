/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.ModeloTabela;

import Classes.ItemVenda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juliana
 */
public class ModeloTabelaCarrinho extends AbstractTableModel {
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_QTD = 2;
    private static final int COLUNA_PRECO = 3;
    
    private String colunas[] = new String[]{"Código", "Nome", "Quantidade", "Preço"};
    private ArrayList<ItemVenda> itens;
    
    public ModeloTabelaCarrinho(ArrayList<ItemVenda> itens){
        this.itens = new ArrayList<ItemVenda>(itens);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return itens.size();
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
        ItemVenda itemvenda = itens.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                return itemvenda.getCodigoProduto();
            case COLUNA_NOME:
                return itemvenda.getNome();
            case COLUNA_QTD:
                return itemvenda.getQtdVendida();
            case COLUNA_PRECO:
                return itemvenda.getPreco();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        ItemVenda itemvenda = itens.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                itemvenda.setCodigoProduto(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_NOME:
                itemvenda.setNome(valor.toString());
                break;
            case COLUNA_QTD:
                itemvenda.setQtdVendida(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_PRECO:
                itemvenda.setPreco(Double.parseDouble(valor.toString()));
                break;
        }
    }
    
    public ItemVenda getItemVenda(int indice){
        return itens.get(indice);
    }
    public void inserirItemVenda(ItemVenda itemvenda){
        itens.add(itemvenda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarItemVenda(int indice, ItemVenda itemvenda){
        itens.set(indice, itemvenda);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirItemVenda(int indice){
        itens.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }
    public ArrayList<ItemVenda> getItens()
    {
        return itens;
    }
}
