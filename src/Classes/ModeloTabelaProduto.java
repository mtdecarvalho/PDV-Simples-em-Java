package Classes;

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
    private ArrayList<ClientePF> produtos;
    
    public ModeloTabelaProduto(ArrayList<ClientePF> clientes){
        this.clientes = new ArrayList<ClientePF>(clientes);
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return clientes.size();
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
        ClientePF produto = produtos.get(linha);
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
        ClientePF produto = produtos.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                produto.setCodigo(valor.toString());
                break;
            case COLUNA_NOME:
                produto.setNome(valor.toString());
                break;
            case COLUNA_QTD:
                produto.setQtdEstoque(valor.toString());
                break;
            case COLUNA_UNIDADE:
                produto.setUnidade(valor.toString());
                break;
            case COLUNA_PRECO:
                produto.setPreco(valor.toString());
                break;
            case COLUNA_ULTIMA_VENDA:
                produto.setUltimaVenda(valor.toString());
                break;
                
        }
    }
    
    public ClientePF getContato(int indice){
        return clientes.get(indice);
    }
    public void inserirContato(ClientePF cliente){
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarContato(int indice, ClientePF cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirContato(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
