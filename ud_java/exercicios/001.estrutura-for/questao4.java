import java.util.Scanner;

public class questao4 {
	
	/*
	 * Fazer um programa para ler um número N. Depois leia N pares de números e mostre a
	 * divisão do primeiro pelo segundo. Se o denominador for igual a zero, mostrar a
	 * mensagem "divisao impossivel".
	 *
	 * Entrada:		Saida:
	 * 3			
	 * 3 -2			-1.5
	 * -8 0			divisao impossivel
	 *  0 8			0.0
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int qtd = sc.nextInt();
		
		double numerador = 0;
		double denominador = 0;
		double resultado = 0;
		
		for (int i = 0; i < qtd; i++) {
			numerador = sc.nextInt();
			denominador = sc.nextInt();

			if (denominador == 0) {
				System.out.println("divisao impossivel");
			} else {
				resultado = numerador / denominador;
		
				System.out.println(resultado);
			}

		}


		sc.close();
	}
}
