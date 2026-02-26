package processador;

public class Computador {
    
    private String marca;
    private int memoriaRAM;
    private Processador processador;
    
    public Computador(){
        this.marca = null;
        this.memoriaRAM = 0;
        this.processador = new Processador();
    }

    public Computador(String marca, Processador processador, int memoriaRAM) {
        this.marca = marca;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
    }
    
    public String getMarca (){
        return marca;
    }
    
    public void setMarca (String marca){
        this.marca = marca;
    }

    public int getMemoriaRAM (){
        return memoriaRAM;
    }

    public void setMemoriaRAM (int memoriaRAM){
        this.memoriaRAM = memoriaRAM;
    }

    public Processador getProcessador (){
        return processador;
    }

    public void setProcessador (Processador processador){
        this.processador = processador;
    }

    public void exibirComputador() {
        System.out.println("Computador{" +
                "marca='" + marca + '\'' +
                ", memoriaRAM=" + memoriaRAM +
                ", process=" + processador.getModelo() +
                '}');
    }

    public void trocarProcessador(Processador novoProcessador){
        processador = novoProcessador;
    }

    public void realizarManutencao() {
        System.out.println("O computador está em manutenção preventiva!");
    }
}
