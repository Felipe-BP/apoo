/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import model.dao.ProdutoDAO;
import src.view.TabelaItens;

/**
 *
 * @author Felipe
 */
public class TableItensController {
    private TabelaItens tI;
    private List<Produto> produtos = new ArrayList();
    private ProdutoDAO pd = new ProdutoDAO();
    
    public TableItensController(TabelaItens tI){
        this.tI = tI;
    }
    
    public void resetTable(){
        int i = tI.getModel().getRowCount();
        for(int j=0; j<i; j++){
            tI.getModel().removeRow(j);
        }
    }
    
    public void setTable(){
        try{
            this.produtos = pd.consultar();
            for(Produto p : produtos){
                String[] prod = {""+p.getNome(), ""+p.getDescricao(), ""+p.getPreco(), ""+p.getCategoria()};
                tI.getModel().addRow(prod);
            }
        } catch(SQLException e){
            System.out.print("Error: " + e.getMessage());
        }
    }
    
    public Object getSelectLine(){
        Object i = tI.getjTable1().getValueAt(tI.getjTable1().getSelectedRow(), 1);
        return i;
    }
}
