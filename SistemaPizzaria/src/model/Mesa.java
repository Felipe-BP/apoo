package model;

/**
 *
 * @author christian
 */
public class Mesa {

    private char[] codigo;
    private int lugares;
    private int situacao;
    private boolean status;
    
    public static final int LIVRE = 1, OCUPADA = 2, RESERVADA = 3;
    
    public Mesa(char[] codigo, int lugares) {
        this(codigo, lugares, LIVRE, true);
    }
    
    public Mesa(char[] codigo, int lugares, int situacao, boolean status) {
        this.codigo = codigo;
        this.lugares = lugares;
        this.situacao = situacao;
        this.status = status;
    }

    public char[] getCodigo() {
        return codigo;
    }

    public void setCodigo(char[] codigo) {
        this.codigo = codigo;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public boolean getStatus() {
        return this.status;
    }

    public void changeStatus() {
        this.status = !this.status;
    }
    
}
