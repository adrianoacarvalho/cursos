import java.util.Scanner;

/* Problema "soma_vetores"
 *
 *  Faça um programa para ler dois vetores A e B, contendo N elementos cada. 
 *  Em seguida, gere um terceiro vetor C onde cada elemento de C é a soma 
 *  dos elementos correspondentes de A e B. Imprima o vetor C gerado.
 *
 * Exemplo:
 *
 * Quantos valores vai ter cada vetor? 6 
 * Digite os valores do vetor A:
 * 8
 * 2
 * 11
 * 14
 * 13
 * 20
 * Digite os valores do vetor B: 
 * 5
 * 10
 * 3
 * 1
 * 10
 * 7
 * VETOR RESULTANTE: 
 * 13
 * 12 
 * 14 
 * 15 
 * 23 
 * 27
 *
*/

public class soma_vetores {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int N = sc.nextInt();
		
		int[] vetorA = new int[N];
		int[] vetorB = new int[N];
		int[] vetorC = new int[N];

		System.out.println("\nDigite os valores do Vetor A:");
		for (int i = 0; i < N; i++){
			vetorA[i] = sc.nextInt();
		}
		
		System.out.println("\nDigite os valores do Vetor B:");
		for (int i = 0; i < N; i++){
			vetorB[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			vetorC[i] = vetorA[i] + vetorB[i];
		}

		System.out.println("\nVETOR RESULTANTE:");
		
		for (int i = 0; i < N; i++) {
			System.out.println(vetorC[i]);
		}
		sc.close();
	}
}
