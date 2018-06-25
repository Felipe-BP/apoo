package model.dao;

import model.Produto;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author christian
 */
public class ProdutoDAO {
    
    private final Database db;
    private List<Produto> lista;
    private String sql;
    
    public ProdutoDAO() {
        this.db = new Database();
        this.lista = new ArrayList();
        this.sql = "";
    }

    public void inserir(Produto produto) throws SQLException {
        this.sql = "insert into produto values (";
        this.sql += "'" + produto.getCodigo() + "', ";
        this.sql += "'" + produto.getNome() + "', ";
        this.sql += "'" + produto.getDescricao() + "', ";
        this.sql += produto.getPreco() + ", ";
        this.sql += produto.getCategoria() + ", ";
        this.sql += produto.getStatus() + ");";
        
        this.db.execute(this.sql);
    }
    
    public void atualizar(Produto produto) throws SQLException {
        this.sql = "update produto set";
        this.sql += "pro_nome = '" + produto.getNome() + "', ";
        this.sql += "pro_descricao = '" + produto.getDescricao() + "', ";
        this.sql += "pro_preco = " + produto.getPreco() + ", ";
        this.sql += "pro_categoria = " + produto.getCategoria() + ", ";
        this.sql += "pro_status = " + produto.getStatus();
        this.sql += " where pro_codigo = " + produto.getCodigo() + ";";
        
        this.db.execute(this.sql);
    }
    
    public void remover(int id) throws SQLException {
        this.sql = "update produto set pro_status = false"
                + " where pro_codigo = " + id;
        this.db.execute(this.sql);
    }
    
    public List<Produto> consultar() throws SQLException {
        this.sql = "select * from produto";
        
        ResultSet rs = this.db.query(this.sql);
        
        while (rs.next()) {
            String codigo = rs.getString("pro_codigo");
            String nome = rs.getString("pro_nome");
            String descricao = rs.getString("pro_descricao");
            double preco = rs.getDouble("pro_preco");
            int categoria = rs.getInt("pro_categoria");
            lista.add(new Produto(codigo, nome, descricao, preco, categoria));
        }
        
        return lista;
    }
    
    public String[] consultarByName(Object descri) throws SQLException {
        this.sql = "select * from produto where pro_codigo = " + "'" + descri + "'";
        
        ResultSet rs = this.db.query(this.sql);
        
        String codigo = rs.getString("pro_codigo");
        String nome = rs.getString("pro_nome");
        String descricao = rs.getString("pro_descricao");
        double preco = rs.getDouble("pro_preco");
        int categoria = rs.getInt("pro_categoria");
        String[] prod = {codigo, nome, descricao, ""+preco, ""+categoria};
        return prod;
    }
    
}
