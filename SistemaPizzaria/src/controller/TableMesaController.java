/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import model.dao.ProdutoDAO;
import src.view.TabelaItens;
import src.view.TelaMesa;

/**
 *
 * @author Felipe
 */
public class TableMesaController{
    private TelaMesa tela;
    private TableItensController control;
    private List<Produto> produtos = new ArrayList();
    private ProdutoDAO pd = new ProdutoDAO();
            
    public TableMesaController(TelaMesa t, TabelaItens tI){
        this.tela = t;
        this.control = new TableItensController(tI);
    }
    
    public void setTable(){
        try{
            Object prod = control.getSelectLine();
            tela.getModel().addRow(pd.consultarByName(prod));
        }catch (NullPointerException e){
            System.out.println("Error: " + e.getCause());
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
