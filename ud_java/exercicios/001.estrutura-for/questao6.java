import java.util.Scanner;

public class questao6 {
	
	/*
	 * Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N = N * (N - 1) *
	 * (N - 2) * (N - 3) * ... * 1. Lembrando que, por definição, fatorial de 0 é 1.
	 *
	 * Entrada:			Saida:
	 * 4				24
	 *
	 * Entrada:			Saida:
	 * 1				1
	 *
	 * Entrada: 			Saida:
	 * 5				120
	 *
	 * Entrada:			Saida:
	 * 0				1
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int qtd = sc.nextInt();
		
		int result = qtd;
	 	
		if(qtd != 0){
		  for (int i = (qtd - 1); i > 0; i--) {
			result = result * i;

		  }
		} else {
		  result = 1;
		}

		System.out.println(result);

		sc.close();
	}
}
