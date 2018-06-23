package model;

/**
 *
 * @author christian
 */
public class Pedido {
    
    private int codigo, status;
    private Mesa mesa;
    private double total;
    
    public static final int ABERTO = 1;
    public static final int FECHADO = 2;
    public static final int PAGO = 3;
    
    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.total = 0;
        this.status = ABERTO;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
