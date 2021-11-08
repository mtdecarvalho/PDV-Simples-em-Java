package Classes.ModeloTabela;

import Classes.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaProduto extends AbstractTableModel {
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_QTD = 2;
    private static final int COLUNA_UNIDADE = 3;
    private static final int COLUNA_PRECO = 4;
    private static final int COLUNA_ULTIMA_VENDA = 5;
    
    private String colunas[] = new String[]{"Código", "Nome", "Quantidade em Estoque",
        "Unidade", "Preco", "Ultima Venda"};
    private ArrayList<Produto> produtos;
    
    public ModeloTabelaProduto(ArrayList<Produto> produtos){
        this.produtos = new ArrayList<Produto>(produtos);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return produtos.size();
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
        Produto produto = produtos.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                return produto.getCodigo();
            case COLUNA_NOME:
                return produto.getNome();
            case COLUNA_QTD:
                return produto.getQtdEstoque();
            case COLUNA_UNIDADE:
                return produto.getUnidade();
            case COLUNA_PRECO:
                return produto.getPreco();
            case COLUNA_ULTIMA_VENDA:
                return produto.getUltimaVenda();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        Produto produto = produtos.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                produto.setCodigo(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_NOME:
                produto.setNome(valor.toString());
                break;
            case COLUNA_QTD:
                produto.setQtdEstoque(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_UNIDADE:
                produto.setUnidade(valor.toString());
                break;
            case COLUNA_PRECO:
                produto.setPreco(Double.parseDouble(valor.toString()));
                break;
            case COLUNA_ULTIMA_VENDA:
                produto.setUltimaVenda(valor.toString());
                break;
                
        }
    }
    
    public Produto getProduto(int indice){
        return produtos.get(indice);
    }
    public void inserirProduto(Produto produto){
        produtos.add(produto);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarProduto(int indice, Produto produto){
        produtos.set(indice, produto);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirProduto(int indice){
        produtos.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
