import java.util.Scanner;

/* Problema "aprovados"
 *
 * Fazer um programa para ler um conjunto de N nomes de alunos, 
 * bem como as notas que eles tiraram no 1o e 2o semestres. Cada
 * uma dessas informações deve ser armazenada em um vetor. Depois,
 * imprimir os nomes dos alunos aprovados, considerando aprovados
 * aqueles cuja média das notas seja maior ou igual a 6.0 (seis).
 *
 * Exemplo:
 *
 * Quantos alunos serao digitados? 4
 * Digite nome, primeira e segunda nota do 1o aluno: 
 * Joao Silva 
 * 7.0
 * 8.5
 * Digite nome, primeira e segunda nota do 2o aluno: 
 * Maria Teixeira
 * 9.2
 * 6.5
 * Digite nome, primeira e segunda nota do 3o aluno:
 * Carlos Carvalho
 * 5.0
 * 6.0
 * Digite nome, primeira e segunda nota do 4o aluno: 
 * Teresa Pires
 * 5.5
 * 6.5
 * Alunos aprovados:
 * Joao Silva
 * Maria Teixeira
 * Teresa Pires
 *
*/

public class aprovados {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos alunos serao digitados? ");
		int N = sc.nextInt();
		
		String[] aluno = new String[N];
		double[][] notas = new double[N][2];
		
		for (int i = 0; i < aluno.length; i++){
			System.out.println("Digite nome, primeira e segunda nota do " + (i+1) + "o aluno:");
			sc.nextLine();
			aluno[i] = sc.nextLine();
			notas[i][0] = sc.nextDouble();
			notas[i][1] = sc.nextDouble();
		}
		
		System.out.println("Alunos aprovados\n");
		for (int i = 0; i < aluno.length; i++){
			if(((notas[i][0] + notas[i][1]) / 2) >= 6.0) {
				System.out.println(aluno[i]);
			}
		}

		sc.close();
	}
}
