package model;

/**
 *
 * @author christian
 */
public class Produto {

    private String codigo, nome, descricao;
    private double preco;
    private int categoria;
    private boolean status;
    
    public static int PIZZA = 1;
    public static int BEBIDA = 2;
    public static int SALGADO = 3;
    public static int DOCE = 4;
    
    public Produto() {}
    
    public Produto(String codigo, String nome, String descricao, double preco,
            int categoria) {
        this(codigo, nome, descricao, preco, categoria, true);
    }
    
    public Produto(String codigo, String nome, String descricao, double preco,
            int categoria, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public boolean getStatus() {
        return this.status;
    }
    
    public void changeStatus() {
        this.status = !this.status;
    }
    
}
