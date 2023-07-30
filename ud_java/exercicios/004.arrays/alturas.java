import java.util.Scanner;
import entities.Pessoas;

/* Problema "Alturas"
 *
 * Fazer um programa para ler nome, idade e altura de N pessoas, conforme exemplo. Depois, mostrar na 
 * tela a altura média das pessoas, e mostrar também a porcentagem de pessoas com menos de 16 anos, 
 * bem como os nomes dessas pessoas caso houver. 
 *
 * Exemplo:
 *
 * Quantas pessoas serao digitadas? 5
 * Dados da 1a pessoa: 
 * Nome: Joao
 * Idade: 15
 * Altura: 1.82
 * Dados da 2a pessoa: 
 * Nome: Maria
 * Idade: 16
 * Altura: 1.60
 * Dados da 3a pessoa: 
 * Nome: Teresa
 * Idade: 14
 * Altura: 1.58
 * Dados da 4a pessoa: 
 * Nome: Carlos
 * Idade: 21
 * Altura: 1.65
 * Dados da 5a pessoa: 
 * Nome: Paulo
 * Idade: 17
 * Altura: 1.78
 * Altura média: 1.69 
 * Pessoas com menos de 16 anos: 40.0% 
 * Joao 
 * Teresa 
 *
 *
*/

public class alturas {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas? ");
		int N = sc.nextInt();
		
		Pessoas[] pessoas = new Pessoas[N];

		String nome;
		int idade = 0;
		double altura = 0;
			
		for (int i = 0; i < N; i++){
			System.out.println("Dados da "+ (i+1)  +"a pessoa");
			sc.nextLine();
			System.out.println("Nome: ");
			nome = sc.nextLine();
			System.out.println("Idade: ");
			idade = sc.nextInt();
			System.out.println("Altura: ");
			altura = sc.nextDouble();

			pessoas[i] = new Pessoas(nome, idade, altura);
		}
		
		int menor16 = 0;
		double media = 0;
		
		for (int i = 0; i < pessoas.length; i++){
			media += pessoas[i].getAltura();

			if (pessoas[i].getIdade() < 16){
				menor16 += 1;
			}
		}
		
		media = media / N;
		
		double percentual = (menor16 * 100) / N;

		System.out.println("\n Altura media = " + media);

		System.out.println("\n Pessoas com menos de 16 anos: " + percentual + "%");

		for (int i =0; i < pessoas.length; i++){
			if (pessoas[i].getIdade() < 16){
				System.out.println(pessoas[i].getNome());
			}
		}
		sc.close();
	}
}
