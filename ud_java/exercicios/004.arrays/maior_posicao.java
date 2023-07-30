import java.util.Scanner;

/* Problema "Maior_posicao"
 *
 * Faça um programa que leia N números reais e armazene-os em um vetor. 
 * Em seguida, mostrar na tela o maior número do vetor (supor não haver 
 * empates). Mostrar também a posição do maior elemento, considerando 
 * a primeira posição como 0 (zero). 
 *
 * Exemplo:
 *
 * Quantos numeros voce vai digitar? 6 
 * Digite um numero: 8.0
 * Digite um numero: 4.0
 * Digite um numero: 10.0
 * Digite um numero: 14.0
 * Digite um numero: 13.0 
 * Digite um numero: 7.0
 * 
 * MAIOR VALOR = 14.0
 * POSICAO DO MAIOR VALOR = 3
 *
*/

public class maior_posicao {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int N = sc.nextInt();
		
		double[] numero = new double[N];


		for (int i = 0; i < numero.length; i++){
			System.out.println("Digite um numero: ");
			numero[i] = sc.nextDouble();
		}
		
		double numAtual = 0;
		int pos = 0;

		for (int i = 0; i < numero.length; i++){
			if (numero[i] > numAtual) {
				numAtual = numero[i];
				pos = i;
			}
		}

		System.out.println("\nMAIOR VALOR = " + numAtual);
		System.out.println("POSICAO DO MAIOR VALOR = " + pos);

		sc.close();
	}
}
