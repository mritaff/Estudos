package processador;

public class Processador {
    private String modelo;
    private double frequenciaGHz;
    private int nucleos;

    public Processador(){
        this.modelo = null;
        this.frequenciaGHz = 0.0;
        this.nucleos = 0;
    }

    public Processador(String modelo, double frequenciaGHz, int nucleos){
        this.modelo = modelo;
        this.frequenciaGHz = frequenciaGHz;
        this.nucleos = nucleos;
    }
    
    public String getModelo (){
        return modelo;
    }
    
    public void setModelo (String modelo){
        this.modelo = modelo;
    }
    
    public double getFrequenciaGHz (){
        return frequenciaGHz;
    }
    
    public void setFrequenciaGHz (double frequenciaGHz){
        this.frequenciaGHz = frequenciaGHz;
    }
    
    public int getNucleos (){
        return nucleos;
    }
    
    public void setNucleos (int nucleos){
        this.nucleos = nucleos;
    }
    
    public String toString() {
        return "Modelo = " + modelo + "\nFrequencia (GHz) = " + frequenciaGHz + "\nNucleos = " + nucleos;
    }
}
