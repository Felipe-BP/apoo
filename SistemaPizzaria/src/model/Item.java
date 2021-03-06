package model;

/**
 *
 * @author christian
 */
public class Item {

    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    
    public Item() {}
    
    public Item(Pedido pedido, Produto produto, int quant) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quant;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
