import java.util.Scanner;

public class questao3 {
	
	/*
	 * Leia 1 valor inteiro N, que representa o número de casos de teste que vem a seguir. 
	 * Cada caso de teste consiste de 3 valores reais, cada um deles com uma casa decimal.
	 * Apresente a média ponderada para cada um destes conjuntos de 3 valores, sendo que o 
	 * primeiro valor tem peso 2, o segundo valor tem peso 3 e o terceiro valor tem 
	 * peso 5.
	 *
	 * formula de media ponderara (x*peso1 + y*peso2 + z*peso3) / (peso1 + peso2 + peso3)
	 *
	 * entrada		saida
	 * 3
	 * 6.5 4.3 6.2		5.7
	 * 5.1 4.2 8.1		6.3
	 * 8.0 9.0 10.0		9.3
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int qtd = sc.nextInt();
		
		double x, y, z, media = 0;
		
		int peso_x = 2;
		int peso_y = 3;
		int peso_z = 5;
		


		for (int i = 0; i < qtd; i++) {
			
			x = sc.nextDouble();
			y = sc.nextDouble();
			z = sc.nextDouble();

			media = ((x * peso_x) + (y * peso_y) + (z * peso_z)) / (peso_x + peso_y + peso_z);
			System.out.println("%.1f%n", media);

		}


		sc.close();
	}
}
