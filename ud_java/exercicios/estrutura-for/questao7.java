import java.util.Scanner;

public class questao7 {
	
	/*
	 * Fazer um programa para ler um número positivo N. O programa deve então mostrar na tela N
	 * linhas, começando de 1 até N. Para cada linha, mostrar o número da linha, depois o quadrado
	 * e o cubo do valor, conforme exemplo.
	 *
	 * Entrada:			Saida:
	 * 5				1 1 1
	 * 				2 4 8
	 * 				3 9 27
	 * 				4 16 64
	 * 				5 25 125
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
	 	int numero_1 = 0;
		int numero_2 = 0;
		int numero_3 = 0;


		for (int i = 1; i <= number; i++) {
			numero_1 = i;
			numero_2 = i * i;
			numero_3 = i * i * i;
			System.out.printf("%d %d %d%n", numero_1, numero_2, numero_3); 

		}

		sc.close();
	}
}
