import java.util.Scanner;

/* Problema "Soma_Vetor"
 *
 * Faça um programa que leia N números reais e 
 * armazene-os em um vetor. Em seguida: 
 * - Imprimir todos os elementos do vetor 
 * - Mostrar na tela a soma e a média dos elementos do vetor 
 *
 *
 * Exemplo:
 *
 * Quantos numeros voce vai digitar? 4
 * Digite um numero: 8.0
 * Digite um numero: 4.0
 * Digite um numero: 10.0
 * Digite um numero: 14.0
 * VALORES = 8.0 4.0 10.0 14.0 
 * SOMA = 36.00 
 * MEDIA = 9.00 
 *
*/

public class somaVetor {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int N = sc.nextInt();
		
		double[] numero = new double[N];


		for (int i = 0; i < numero.length; i++){
			System.out.println("Digite um numero: ");
			numero[i] = sc.nextInt();
		}
		
		
		double soma = 0;
		double media = 0;
		
		System.out.print("VALORES = ");
		for (int i = 0; i < numero.length; i++){
			
			System.out.print(numero[i] + " ");
			soma += numero[i];
		}
		
		media = soma / N;
		

		System.out.print("\n SOMA = ");
		System.out.print(soma);

		System.out.print("\n MEDIA = ");
		System.out.println(media);
		sc.close();
	}
}
