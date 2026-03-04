import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Empresa amazon = new Empresa();

        Scanner sc = new Scanner(System.in);
        int caso = 0;

        System.out.println("Bem-vindo ao menu da empresa");

        while (true) {
            System.out.println("Comandos:"  + "\n1 - Cadastrar empregado" +
                    "\n2 - Aumentar salário" + "\n3 - Demitir" + "\n4 - Listar empregados" + "\n5 - Interromper");
            caso = sc.nextInt();
            switch (caso) {
                case 1:
                    System.out.println("Digite o id, nome, cargo e sálario do empregado");

                    System.out.print("Id: ");
                    int id = sc.nextInt();

                    System.out.print("Nome: ");
                    String nome = sc.next();

                    System.out.print("Cargo: ");
                    String cargo = sc.next();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();

                    amazon.cadastrarEmpregado(id, nome, cargo, salario);

                    break;
                case 2:
                    System.out.println("Digite o id e o aumento percentual do empregado");

                    System.out.print("Id: ");
                    id = sc.nextInt();

                    System.out.print("Percentual: ");
                    double percentual = sc.nextDouble();

                    amazon.aplicarAumento(id, percentual);

                    break;
                case 3:
                    System.out.println("Digite o id do empregado");

                    System.out.print("Id: ");
                    id = sc.nextInt();

                    amazon.demitirEmpregado(id);

                    break;
                case 4:
                    amazon.listarEmpregados();
                    break;
                case 5:
                    return;
                default:
                    return;
            }
        }
    }
}