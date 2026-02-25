package processador;

public class Main {
    public static void main(String[] args){
        Processador processador = new Processador();
        processador.setModelo("Sergio");
        processador.setFrequenciaGHz(600.0);
        processador.setNucleos(10);
        
        System.out.println(processador.virarString());
    }
}
