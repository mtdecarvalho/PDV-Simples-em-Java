/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.DAO.VendaDAO;
import Classes.DAO.formaPagamentoDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Carrinho;

/**
 *
 * @author Juliana
 */
public class PDF {
    
    public void gerarRelatorio(ArrayList<Venda> vendas, ArrayList<FormaPagamento> pagamentos){
                   
        Document document = new Document();   
              
        try {
            PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));              
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
            
            document.open();
            Paragraph p = new Paragraph("Relatório de Vendas");
            p.setAlignment(Element.ALIGN_CENTER);               
            document.add(p);               
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Código Venda"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Data e Hora"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Preço Total"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Codigo do Cliente"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);            
            table.setHeaderRows(1);
            for(int i = 0; i < vendas.size(); i++){
                table.addCell(String.valueOf(vendas.get(i).getCodigo()));                
                table.addCell(vendas.get(i).getData());
                table.addCell(String.valueOf(vendas.get(i).getPrecoTotal()));
                if (vendas.get(i).getCodigoCliente() == "N/A")
                {
                    table.addCell(String.valueOf(vendas.get(i).getCodigoCliente()));
                } else {
                    table.addCell("");
                }                        
            }
                
            document.add(table);
                
            document.newPage();
            PdfPTable table2 = new PdfPTable(3);
            PdfPCell c2 = new PdfPCell(new Phrase("Código"));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(c2);
            c2 = new PdfPCell(new Phrase("Forma de pagamento"));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(c2);
            c2 = new PdfPCell(new Phrase("Total Vendido"));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(c2);
            table2.setHeaderRows(1);
            for(int i = 0; i < pagamentos.size(); i++){
                table2.addCell(String.valueOf(pagamentos.get(i).getCodigo()));                
                table2.addCell(pagamentos.get(i).getNome());
                table2.addCell(String.valueOf(pagamentos.get(i).getValorTotal()));
                            
            }
                
            document.add(table2);
                                               
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            document.close();
        }  

        try {
            Desktop.getDesktop().open(new File("relatorio.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gerarNotaFiscal(Venda venda, String f){
        Document document = new Document();   
              
            try {
                PdfWriter.getInstance(document, new FileOutputStream("venda.pdf"));
                document.open(); 
                Paragraph p1 = new Paragraph("=============================\n"
                        + "VENDA #" + venda.getCodigo()
                        + "\n=============================");
                p1.setAlignment(Element.ALIGN_CENTER);
                document.add(p1); 
                if(venda.getCodigoCliente() == "N/A"){
                    Paragraph p2 = new Paragraph("N° Cliente: " + venda.getCodigoCliente() + "\n");
                    p2.setAlignment(Element.ALIGN_CENTER);
                    document.add(p2);
                } 
                
                if(venda.getFormaPagamento() == 0){
                    Paragraph p3 = new Paragraph("Forma de pagamento: Cartão de crédito\n");
                    p3.setAlignment(Element.ALIGN_CENTER);
                    document.add(p3);
                }
                else{
                    Paragraph p3 = new Paragraph("Forma de pagamento: Dinheiro\n");
                    p3.setAlignment(Element.ALIGN_CENTER);
                    document.add(p3);
                }
                Paragraph p4 = new Paragraph("Data: " + venda.getData() + "\nHora: " + f +
                        "\nTotal: R$ " + String.format("%.2f", venda.getPrecoTotal()));
                p4.setAlignment(Element.ALIGN_CENTER);
                document.add(p4); 
                Paragraph p5 = new Paragraph("=============================");
                p5.setAlignment(Element.ALIGN_CENTER);
                document.add(p5);
            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);           
            } finally {
                document.close();
            }  
            
            try {
                Desktop.getDesktop().open(new File("venda.pdf"));
            } catch (IOException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
