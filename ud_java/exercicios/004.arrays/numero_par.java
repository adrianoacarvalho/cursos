import java.util.Scanner;

/* Problema "Numeros Pares"
 *
 * Faça um programa que leia N números inteiros e armazene-os em um vetor. 
 * Em seguida, mostre na tela todos os números pares, e também a 
 * quantidade de números pares. 
 *
 * Exemplo:
 *
 * Quantos numeros voce vai digitar? 6 
 * Digite um numero: 8
 * Digite um numero: 2
 * Digite um numero: 11
 * Digite um numero: 14 
 * Digite um numero: 13 
 * Digite um numero: 20
 * 
 * NUMEROS PARES:
 * 8  2  14  20
 *
 * QUANTIDADE DE PARES = 4
 *
*/

public class numero_par	 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int N = sc.nextInt();
		
		int[] numero = new int[N];


		for (int i = 0; i < numero.length; i++){
			System.out.println("Digite um numero: ");
			numero[i] = sc.nextInt();
		}
		
		System.out.println("\nNUMEROS NEGATIVOS: ");
		
		int qtd = 0;

		for (int i = 0; i < numero.length; i++){
			if (numero[i] % 2 == 0) {
				System.out.print(numero[i] + " ");
				qtd += 1;
			}
		}

		System.out.println("\nQuantidade de Pares = " + qtd);

		sc.close();
	}
}
