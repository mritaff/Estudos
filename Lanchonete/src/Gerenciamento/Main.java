package Gerenciamento;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Maomao", "882356789");

        Pedido p1 = new Pedido("001", 7, c1);

        p1.exibirPedido();

        p1.atualizarDadosCliente(1, "Shinji", "783512059");

        System.out.println(" ");
        p1.exibirPedido();

        System.out.println(" ");
        System.out.println("INFORMAÇÕES CLIENTES");
        System.out.println(c1.toString());
    }
}