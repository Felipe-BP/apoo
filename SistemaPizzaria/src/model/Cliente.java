package model;

/**
 *
 * @author christian
 */
public class Cliente {

    private int codigo;
    private String nome, cpf;
    private String telefone;
    private boolean status;
    
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.status = true;
    }
    
    public Cliente(String nome, String telefone, String cpf) {
        this(nome, telefone);
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void addTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus() {
        this.status = !this.status;
    }
    
    
    
}
