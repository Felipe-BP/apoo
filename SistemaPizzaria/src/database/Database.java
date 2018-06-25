package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author christian
 */
public class Database {

    private String url;
    private Connection conn;
    private Statement stm;
    private PreparedStatement prepStm;
    private ResultSet result;
    
    private final String ERRO = "Erro de conexão ao banco de dados.";
    
    public Database() {
        this.url = "jdbc:mysql://localhost:3306/pizzaria"+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        this.connect();
    }
    
    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, "root", "felipe");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(ERRO + "[SQL] " + e.getMessage());
        }
    }
    
    public void disconnect() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.err.println("Erro de desconexão ao banco de dados.");
        }
    }
    
    public void execute(String sql) throws SQLException {
        this.stm = this.conn.createStatement();
        this.stm.execute(sql);
    }
    
    public ResultSet query(String sql) throws SQLException {
        this.stm = this.conn.createStatement();
        this.result = this.stm.executeQuery(sql);
        return this.result;
    }
    
}
