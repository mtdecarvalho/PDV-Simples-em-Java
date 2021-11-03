package Classes.ModeloTabela;

import Classes.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaCliente extends AbstractTableModel {
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_TELEFONE = 2;
    private static final int COLUNA_EMAIL = 3;
    private static final int COLUNA_CEP = 4;
    
    private String colunas[] = new String[]{"Código", "Nome", "Telefone", "Email", "CEP"};
    private ArrayList<Cliente> clientes;
    
    public ModeloTabelaCliente(ArrayList<Cliente> clientes){
        this.clientes = new ArrayList<Cliente>(clientes);
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
        Cliente cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                return cliente.getCodigo();
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_TELEFONE:
                return cliente.getTelefone();
            case COLUNA_EMAIL:
                return cliente.getEmail();
            case COLUNA_CEP:
                return cliente.getEndereco().getCEP();
        }
        return "";
    }
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        Cliente cliente = clientes.get(linha);
        switch(coluna){
            case COLUNA_CODIGO:
                cliente.setCodigo(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_NOME:
                cliente.setNome(valor.toString());
                break;
            case COLUNA_TELEFONE:
                cliente.setTelefone(Integer.parseInt(valor.toString()));
                break;
            case COLUNA_EMAIL:
                cliente.setEmail(valor.toString());
                break;
            case COLUNA_CEP:
                cliente.getEndereco().setCEP(valor.toString());
                break;
        }
    }
    
    public Cliente getCliente(int indice){
        return clientes.get(indice);
    }
    public void inserirCliente(Cliente cliente){
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void atualizarCliente(int indice, Cliente cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);

    }
    public void excluirCliente(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
        
    }

    
}
