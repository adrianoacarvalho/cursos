import java.util.Scanner;

/* Problema "media_pares"
 *
 * Fazer um programa para ler um vetor de N números inteiros. 
 * Em seguida, mostrar na tela a média aritmética somente dos números 
 * pares lidos, com uma casa decimal. Se nenhum número par for 
 * digitado, mostrar a mensagem "NENHUM NUMERO PAR"
 *
 * Exemplo1:
 *
 * Quantos elementos vai ter o vetor? 6 
 * Digite um numero: 8
 * Digite um numero: 2
 * Digite um numero: 11
 * Digite um numero: 14 
 * Digite um numero: 13 
 * Digite um numero: 20 
 *
 * MEDIA DOS PARES = 11.0
 *
 * Exemplo2:
 * 
 * Quantos elementos vai ter o vetor? 3 
 * Digite um numero: 7
 * Digite um numero: 9
 * Digite um numero: 11
 *
 * NENHUM NUMERO PAR
 *
*/

public class media_pares {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos elementos vai ter o vetor? ");
		int N = sc.nextInt();
		
		int[] numero = new int[N];


		for (int i = 0; i < numero.length; i++){
			System.out.print("Digite um numero: \n");
			numero[i] = sc.nextInt();
		}
		
		double soma = 0;
		double qtd = 0;
		double media = 0;

		for (int i = 0; i < numero.length; i++){
			if (numero[i] % 2 == 0) {
				soma += numero[i];
				qtd += 1;
			}
		}
		if (qtd > 0) {
			media = soma / qtd;
			System.out.println("\n MEDIA DOS PARES = " + media);
		} else {
			System.out.println("NENHUM NUMERO PAR");
		}
		

		sc.close();
	}
}
