import java.util.Scanner;

/* Problema "abaixo_da_media"
 *
 * Fazer um programa para ler um número inteiro N e depois
 * um vetor de N números reais. Em seguida, mostrar na tela
 * a média aritmética de todos elementos com três casas decimais. 
 * Depois mostrar todos os elementos do vetor que estejam abaixo 
 * da média, com uma casa decimal cada.
 *
 * Exemplo:
 * Quantos elementos vai ter o vetor? 4 
 * Digite um numero: 10.0
 * Digite um numero: 15.5
 * Digite um numero: 13.2 
 * Digite um numero: 9.8
 * 
 * MEDIA DO VETOR = 12.125 
 * ELEMENTOS ABAIXO DA MEDIA: 
 * 10.0
 * 9.8
 *
*/

public class abaixo_da_media {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos elementos vai ter o vetor? ");
		int N = sc.nextInt();
		
		double[] numero = new double[N];


		for (int i = 0; i < numero.length; i++){
			System.out.print("Digite um numero: \n");
			numero[i] = sc.nextDouble();
		}
		
		double soma = 0;
		double media = 0;

		for (int i = 0; i < numero.length; i++){
			soma += numero[i];
		}

		media = soma / N;

		System.out.println("\nMEDIA DO VETOR = " + media);
		System.out.println("\nELEMENTOS ABAIXO DA MEDIA");

		for (int i = 0; i < numero.length; i++){
			if(numero[i] < media) {
				System.out.println(numero[i]);
			}
		}

		sc.close();
	}
}
