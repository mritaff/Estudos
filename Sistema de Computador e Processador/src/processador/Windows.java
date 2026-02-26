package processador;

public class Windows {
    public static void main(String[] args){
        Processador p1 = new Processador("Ryzen 5 5600gt", 3.6, 6);
        Computador pc = new Computador("Dell", p1, 16);

        System.out.println(p1.toString());

        pc.exibirComputador();

        pc.trocarProcessador(new Processador("Intel i7 10th gen", 3.8, 8));

        pc.exibirComputador();

        pc.realizarManutencao();
    }
}
