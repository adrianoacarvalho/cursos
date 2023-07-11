import java.util.Scanner;

public class Questao1 {
   	/*
	Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os impares de 1 ate X, um valor por linha, inclusive o X se for o caso.
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
	
		if(x < 1 || x > 1000) {
			System.out.println("Numero invalido");
		
		} else {
	
			for (int i=1;i<=x; i++){
				if(i % 2 != 0){
					System.out.println(i);
				}
			}
		}

		sc.close();
	}
}
