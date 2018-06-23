package model;

import java.util.Calendar;

/**
 *
 * @author christian
 */
public class Reserva {
    
    private int codigo;
    private Cliente cliente;
    private Mesa mesa;
    private Calendar data;
    private boolean status;
    
    public Reserva(Cliente cliente, Mesa mesa, Calendar data) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.data = data;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return this.codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus() {
        this.status = !this.status;
    }
    
}
