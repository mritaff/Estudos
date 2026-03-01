package Gerenciamento;

public class Cliente {
    private int id;
    private String nome, telefone;

    public Cliente(){
        this.id = 0;
        this.telefone = null;
        this.nome = null;
    }

    public Cliente(int id, String nome, String telefone){
        this.id = id;
        this.telefone = telefone;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString() {
        return "Cliente{" +
                "id: '" + id + '\'' +
                ", nome: '" + nome + '\'' +
                ", telefone: '" + telefone + '\'' +
                '}';
    }
}
