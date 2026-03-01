package Gerenciamento;

public class Pedido {
    private String numeroPedido;
    private int valorTotal;
    private Cliente cliente;

    public Pedido(){
        this.numeroPedido = null;
        this.valorTotal = 0;
        this.cliente = null;
    }

    public Pedido(String pedido, int valorTotal, Cliente cliente){
        this.numeroPedido = pedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public String getNumeroPedido(){
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido){
        this.numeroPedido = numeroPedido;
    }

    public int getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(int valorTotal){
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void exibirPedido() {
        System.out.println("DADOS DO PEDIDO");
        System.out.println("n° do pedido: " + numeroPedido);
        System.out.println("Valor total: R$" + valorTotal);
        System.out.println("DADOS DO CLIENTE");
        if (cliente != null) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
        } else {
            System.out.println("Nenhum cliente associado!");
        }
    }

    public void atualizarDadosCliente(int id, String nome, String telefone){
        if (this.cliente != null) {
            this.cliente.setId(id);
            this.cliente.setNome(nome);
            this.cliente.setTelefone(telefone);
        }
    }
}
