import java.util.Scanner;

public class Main {
    /**
     * Gera uma matriz quadrada nxn com valores aleatórios
     * @param n Ordem da matriz, sendo entre 2 e 5
     * @return matriz Matriz de ordem n preenchida com números inteiros
     */
    public static int[][] gerarMatriz (int n) {
        int x, y;

        x = y = n;
        int[][] matriz = new int[x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                int chance = (int)(Math.random() * 4);
                if (chance == 0){
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = (int) (Math.random() * 19) - 9;
                }
            }
        }

        return matriz;
    }

    /**
     * Imprime na tela a matriz com alinhamento para facilitar a leitura
     * @param matriz Matriz quadrada a ser impressa
     */
    public static void imprimirMatriz(int[][] matriz) {

        System.out.print("\t");
        for (int k = 0; k < matriz[0].length; k++) {
            System.out.print("======");
        }

        System.out.print("\n");

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("\t||");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf(" %3d ", matriz[i][j]);
            }
            System.out.println("||\n");
        }

        System.out.print("\t");
        for (int k = 0; k < matriz[0].length; k++) {
            System.out.print("======");
        }
        System.out.println();
    }

    /**
     * Calcula a transposta
     * @param matriz Matriz quadrada original
     * @return Matriz transposta (inverte linhas e colunas)
     */
    public static int[][] calcularTransposta(int[][] matriz) {

        int[][] transposta = new int[matriz[0].length][matriz.length];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {

                transposta[j][i] = matriz[i][j];
            }
        }
        return transposta;
    }

    /**
     * Calcula o produto da diagonal principal e secundária. Retorna os valores como um array.
     * @param matriz
     * @return diagonais Array em que [0] = produto diagonal principal e [1] = produto diagonal secundária
     */
    public static int[] produtoDasDiagonais(int[][] matriz) {
        int[] diagonais = new int [2];
        diagonais[0] = diagonais[1] = 1;

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    diagonais[0] *= matriz[i][j];
                }
                if (i + j == matriz.length - 1) {
                    diagonais[1] *= matriz[i][j];
                }
            }
        }

        return diagonais;
    }

    /**
     * Calcula o determinante da matriz 2x2 com base em Sarrus.
     * @param diagonal Array com [produtoDiagonalPrincipal, produtoDiagonalSecundaria]
     * @return Determinante da matriz 2x2
     */
    public static int calcularDeterminante2x2Sarrus(int[] diagonal) {
        return diagonal[0] - diagonal[1];
    }

    /**
     * Calcula o determinante da matriz 3x3 por Laplace
     * @param matriz Matriz 3x3
     * @return Determinante da matriz 3x3
     */
    public static int calcularDeterminante3x3(int[][] matriz) {
        int sub1 = 0, sub2 = 0, sub3 = 0;

        if (matriz[0][0] != 0) {
            sub1 = determinante2x2Submatriz(matriz, 0);
        }
        if (matriz[0][1] != 0) {
            sub2 = determinante2x2Submatriz(matriz, 1);
        }
        if (matriz[0][2] != 0) {
            sub3 = determinante2x2Submatriz(matriz, 2);
        }

        return (matriz[0][0] * sub1) - (matriz [0][1] * sub2) + (matriz [0][2] * sub3);
    }

    /**
     * Calcula o subdeterminante da matriz 3x3, utilizando Laplace
     * @param matriz Matriz de ordem 3
     * @param coluna Número da coluna que será ignorada
     * @return subdeterminante
     */
    public static int determinante2x2Submatriz(int[][] matriz, int coluna){
        int[] elementos = new int [4];
        int k = 0;

        for(int i = 1; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if(j != coluna){
                    elementos[k] = matriz[i][j];
                    k++;
                }
            }
        }

        return (elementos[0] * elementos[3]) - (elementos[1] * elementos[2]);
    }

    // QUESTÃO EXTRA 1
    /**
     * Calcula a soma dos elementos acima e abaixo da diagonal principal de uma matriz quadrada.
     * @param matriz Matriz quadrada
     * @return Array [somaAcima, somaAbaixo] da diagonal principal
     */

    public static int[] somaRegioesDiagonal(int[][] matriz) { 
        int abaixo = 0, acima = 0;
        int[] somatorios = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i < j) {
                    acima += matriz[i][j];
                } else if (i > j) {
                    abaixo += matriz[i][j];
                }
            }
        }

        somatorios[0] = acima;
        somatorios[1] = abaixo;

        return somatorios;
    }

    /**
     * Mostra a comparação entre as somas das regiões da matriz e diz qual possui o maior valor
     * @param somatorios Array em que [0] = soma acima e [1] = soma abaixo da diagonal principal
     */
    public static void compararSomatorios(int[] somatorios){

        System.out.println("Soma dos elementos acima da diagonal principal é: " + somatorios[0]);
        System.out.println("Soma dos elementos abaixo da diagonal principal é: " + somatorios[1]);

        if (somatorios[0] > somatorios[1]){
            System.out.println("A soma dos elementos acima da diagonal principal é maior que a dos elementos abaixo");
        } else {
            System.out.println("A soma dos elementos abaixo da diagonal principal é maior que a dos elementos acima");
        }

    }

    // QUESTÃO EXTRA 2
    /**
     * Implementação recursiva para determinantes 4x4 e 5x5.
     * Reduz a ordem da matriz eliminando linha 0 e coluna especificada.
     * @param matriz
     * @param coluna
     * @return submatriz
     */
    public static int[][] submatriz(int[][] matriz, int coluna){
        int n = matriz.length;
        int[][] submatriz = new int[n-1][n-1];

        for(int i = 1; i < n; i++){
            int k = 0;
            for (int j = 0; j < n; j++){
                if(j != coluna){
                    submatriz[i-1][k] = matriz[i][j];
                    k++;
                }
            }
        }

        return submatriz;
    }

    /**
     * Função recursiva que calcula o determinante da matriz 4x4
     * @param matriz Matriz 4x4
     * @return determinante da matriz 4x4
     */
    public static int calcularDeterminante4x4(int[][] matriz){
        int sub1 = 0, sub2 = 0, sub3 = 0, sub4 = 0;

        if (matriz[0][0] != 0) {
            sub1 = calcularDeterminante3x3(submatriz(matriz, 0));
        }
        if (matriz[0][1] != 0) {
            sub2 = calcularDeterminante3x3(submatriz(matriz, 1));
        }
        if (matriz[0][2] != 0) {
            sub3 = calcularDeterminante3x3(submatriz(matriz, 2));
        }
        if (matriz[0][3] != 0) {
            sub4 = calcularDeterminante3x3(submatriz(matriz, 3));
        }

        return (matriz[0][0] * sub1) - (matriz [0][1] * sub2) + (matriz [0][2] * sub3) - (matriz[0][3] * sub4);
    }

    /**
     * Função recursiva que calcula o determinante da matriz 5x5
     * @param matriz Matriz 5x5
     * @return Determinante da matriz 5x5 calculado por Laplace
     */
    public static int calcularDeterminante5x5 (int[][] matriz){
        int sub1 = 0, sub2 = 0, sub3 = 0, sub4 = 0, sub5 = 0;

        if (matriz[0][0] != 0) {
            sub1 = calcularDeterminante4x4(submatriz(matriz, 0));
        }
        if (matriz[0][1] != 0) {
            sub2 = calcularDeterminante4x4(submatriz(matriz, 1));
        }
        if (matriz[0][2] != 0) {
            sub3 = calcularDeterminante4x4(submatriz(matriz, 2));
        }
        if (matriz[0][3] != 0) {
            sub4 = calcularDeterminante4x4(submatriz(matriz, 3));
        }
        if (matriz[0][4] != 0){
            sub5 = calcularDeterminante4x4(submatriz(matriz, 4));
        }

        return (matriz[0][0] * sub1) - (matriz [0][1] * sub2) + (matriz [0][2] * sub3) - (matriz[0][3] * sub4) + (matriz[0][4] * sub5);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int n;
        n = leitor.nextInt();
        switch (n) {
            case 2:
            case 3:
            case 4:
            case 5:
                int[][] matriz = gerarMatriz(n);
                imprimirMatriz(matriz);

                imprimirMatriz(calcularTransposta(matriz));

                int[] diagonais = produtoDasDiagonais(matriz);

                System.out.println("\nO valor do produto da diagonal principal é: " + diagonais[0]);
                System.out.println("\nO valor do produto da diagonal secundária é: " + diagonais[1]);

                if (n == 2) {
                    System.out.println("\nO valor do determinante da matriz 2x2 é: " + calcularDeterminante2x2Sarrus(diagonais));
                } else if (n == 3) {
                    System.out.println("\nO valor do determinante da matriz 3x3 é: " + calcularDeterminante3x3(matriz));
                } else if (n == 4) {
                    System.out.println("\nO valor do determinante da matriz 4x4 é: " + calcularDeterminante4x4(matriz));
                } else {
                    System.out.println("\nO valor do determinante da matriz 5x5 é: " + calcularDeterminante5x5(matriz));
                }

                compararSomatorios(somaRegioesDiagonal(matriz));

                leitor.close();
                break;
            default:
                System.out.println("Valor inválido!");
                break;
        }
    }
}