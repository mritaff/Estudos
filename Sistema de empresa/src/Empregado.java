public class Empregado {
    private int id;
    private String nome;
    private double salarioBruto;
    private double imposto;
    private String cargo;

    public Empregado(){
        double i = Math.random() * 100;
        this.id = (int) i;
    }

    public Empregado(int id, String nome, double salarioBruto, double imposto, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
        this.cargo = cargo;
    }

    public Empregado(int id, String nome, double salarioBruto, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = 0;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double calculaSalarioLiquido() {
        double salarioLiquido = this.salarioBruto - this.imposto;
        return salarioLiquido;
    }

    public void aumentaSalario(double percentual) {
        double salarioAumentado = this.salarioBruto + this.salarioBruto * percentual/100;
        this.salarioBruto = salarioAumentado;
    }

    public void exibirInfo() {
        System.out.println(Info());
    }

    private String Info() {
        return "Dados do Empregado: {" +
                "id=" + id +
                ", nome = '" + nome + '\'' +
                ", cargo = '" + cargo + '\'' +
                ", salarioLiquido = R$" + calculaSalarioLiquido() +
                '}';
    }
}