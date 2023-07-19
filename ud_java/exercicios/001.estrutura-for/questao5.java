import java.util.Scanner;

public class questao5 {
	
	/*
	 * Ler um número inteiro N e calcular todos os seus divisores.
	 *
	 * Entrada:			Saida:
	 * 6				1
	 * 				2
	 *				3
	 *				6
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int result = 0;
	 	
		for (int i = 1; i <= number; i++) {
			result = number % i;
			
			if (result == 0){
			   System.out.println(i);
			}

		}

		sc.close();
	}
}
