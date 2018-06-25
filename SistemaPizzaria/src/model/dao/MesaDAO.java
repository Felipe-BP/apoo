package model.dao;

import model.Mesa;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian
 */
public class MesaDAO {

    private Database db;
    private List<Mesa> lista;
    private String sql;
    
    public MesaDAO() {
        this.db = new Database();
        this.lista = new ArrayList();
        this.sql = "";
    }
    
    public void inserir(Mesa mesa) throws SQLException {
        this.sql = "insert into mesa values (";
        this.sql += "'" + mesa.getCodigo() + "', ";
        this.sql += mesa.getLugares() + ", ";
        this.sql += mesa.getSituacao() + ", ";
        this.sql += mesa.getStatus() + ";";
        
        this.db.execute(this.sql);
    }
    
    public void atualizar(Mesa mesa) throws SQLException {
        this.sql = "update mesa set ";
        this.sql += "mesa_lugares = " + mesa.getLugares() + ", ";
        this.sql += "mesa_situacao = " + mesa.getSituacao() + ", ";
        this.sql += "mesa_status = " + mesa.getStatus() + ", ";
        this.sql += "where mesa_codigo = " + mesa.getCodigo() + ";";
        
        this.db.execute(this.sql);
    }
    
    public void atualizarSitO(String codigo) throws SQLException {
        this.sql = "update mesa set mesa_situacao = 1 where mesa_codigo = " + "'" + codigo + "'";
        
        this.db.execute(this.sql);
    }
    
    public void atualizarSitDisp(String codigo) throws SQLException {
        this.sql = "update mesa set mesa_situacao = 0 where mesa_codigo = " + "'" + codigo + "'";
        
        this.db.execute(this.sql);
    }
    
    public void remover(int id) throws SQLException {
        this.sql = "update mesa set ";
        this.sql += "mesa_status = false ";
        this.sql += "where mesa_codigo = " + id + ";";
        
        this.db.execute(this.sql);
    }
    
    public List<Mesa> consultar(String str) throws SQLException {
        this.sql = "select * from mesa where mesa_codigo = '" + str + "%'";
        this.sql += " and mesa_status = true";
        
        ResultSet rs = this.db.query(this.sql);
        
        while (rs.next()) {
            char[] codigo = rs.getString("mesa_codigo").toCharArray();
            int lugares = rs.getInt("mesa_lugares");
            int situacao = rs.getInt("mesa_situacao");
            boolean status = rs.getBoolean("mesa_status");
            lista.add(new Mesa(codigo, lugares, situacao, status));
        }
        
        return lista;
    }
    
    public List<String> consultarDisp() throws SQLException {
        List<String> cod = new ArrayList();
        this.sql = "select mesa_codigo from mesa where mesa_status and mesa_situacao = 0";
        
        ResultSet rs = this.db.query(this.sql);
        
        while (rs.next()) {
            String codigo = rs.getString("mesa_codigo");
            cod.add(codigo);
        }
        
        return cod;
    }
}
