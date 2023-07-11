import java.util.Scanner;

public class questao2 {
	
	/*
	 * Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X que serão lidos em seguida
	 * Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos estão fora do intervalo, 
	 * mostrando essas informaçoes conforme exemplo (use a palava "in" para dentro do intervalo e "out" para
	 * fora do intervalo)
	 *
	 * entrada:		saida:
	 * 5			2 in
	 * 14			3 out
	 * 123
	 * 10
	 * -25
	 *  32
	 */


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int qtd = sc.nextInt();
		
		int number = 0;

		int in = 0;
		int out = 0;

		for (int i = 0; i < qtd; i++) {
			number = sc.nextInt();
			if (number >= 10 && number <= 20) {
			   in += 1;
			} else {
			   out += 1;
			}
		}

	
		System.out.println(in + " in");
		System.out.println(out + " out");
		sc.close();
	}
}
