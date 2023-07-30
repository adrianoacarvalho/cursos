import java.util.Scanner;

/* Problema "Negativos"
 *
 * Faça um programa que leia um número inteiro 
 * positivo N (máximo = 10) e depois N números inteiros 
 * e armazene-os em um vetor. Em seguida, mostrar na tela 
 * todos os números negativos lidos. 
 *
 * Exemplo:
 *
 * Quantos numeros voce vai digitar? 6
 * Digite um numero: 8
 * Digite um numero: -2
 * Digite um numero: 9
 * Digite um numero: 10
 * Digite um numero: -3
 * Digite um numero: -7
 * NUMEROS NEGATIVOS: 
 * -2 
 *  -3 
 *  -7 
 *
*/

public class negativos {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int N = sc.nextInt();
		
		int[] numero = new int[N];


		for (int i = 0; i < numero.length; i++){
			System.out.println("Digite um numero: ");
			numero[i] = sc.nextInt();
		}
		
		System.out.println("NUMEROS NEGATIVOS: ");

		for (int i = 0; i < numero.length; i++){
			if (numero[i] < 0) {
				System.out.println(numero[i]);
			}
		}

		sc.close();
	}
}
