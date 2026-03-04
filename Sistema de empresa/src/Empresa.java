public class Empresa {
    private Empregado[] empregados;
    private int totalEmpregados;

    public Empresa(Empregado[] empregados,int totalEmpregados) {
        this.empregados = empregados;
        this.totalEmpregados = totalEmpregados;
    }

    public Empresa() {
        empregados = new Empregado[100];
        this.totalEmpregados = 0;
    }

    public boolean cadastrarEmpregado (int id, String nome, String cargo, double salario) {
        if (totalEmpregados < 100) {
            Empregado emp = new Empregado(id, nome, salario, cargo);
            for (int i = 0; i < 100; i++) {
                if (empregados[i] == null) {
                    empregados[i] = emp;
                    System.out.println("Empregado cadastrado");
                    totalEmpregados++;
                    return true;
                }
            }
        }
        System.out.println("Empresa cheia patrão");
        return false;
    }

    public void aplicarAumento (int id, double percentual) {
        for (Empregado e : empregados) {
            if (e.getId() == id) {
                e.aumentaSalario(percentual);
                break;
            }
        }
    }

    public boolean demitirEmpregado (int id) {
        for (int i = 0; i < 100; i++) {
            if (empregados[i].getId() == id) {
                empregados[i] = null;
                totalEmpregados--;
                System.out.println("Empregado demitido!");
                // agora ele passa fome..
                return true;
            }
        }
        System.out.println("Empregado não encontrado");
        return false;
    }

    public void listarEmpregados() {
        if (totalEmpregados > 0) {
            for (int i = 0; i < 100; i++) {
                if (empregados[i] != null) {
                    empregados[i].exibirInfo();
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Empresa vazia patrão");
        }
    }
}