import java.util.Scanner;
import entities.Pessoas;

/* Problema "mais_velho"
 *
 *
 * Fazer um programa para ler um conjunto de nomes de pessoas e 
 * suas respectivas idades. Os nomes devem ser armazenados em 
 * um vetor, e as idades em um outro vetor. Depois, mostrar na 
 * tela o nome da pessoa mais velha.
 *
 * Exemplo:
 *
 * Quantas pessoas voce vai digitar? 5 
 * Dados da 1a pessoa:
 * Nome: Joao
 * Idade: 16
 * Dados da 2a pessoa: Nome: Maria
 * Idade: 21
 * Dados da 3a pessoa: Nome: Teresa
 * Idade: 15
 * Dados da 4a pessoa:
 * Nome: Carlos 
 * Idade: 23
 * Dados da 5a pessoa:
 * Nome: Paulo
 * Idade: 17
 *
 * PESSOA MAIS VELHA: Carlos
 *
 */
 
public class maisvelho {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas voce vai digitar? ");
		int N = sc.nextInt();
		
		Pessoas[] pessoas = new Pessoas[N];

		String nome;
		int idade = 0;
			
		for (int i = 0; i < N; i++){
			System.out.println("Dados da "+ (i+1)  +"a pessoa");
			sc.nextLine();
			System.out.println("Nome: ");
			nome = sc.nextLine();
			System.out.println("Idade: ");
			idade = sc.nextInt();

			pessoas[i] = new Pessoas(nome, idade);
		}
		
		int maior = 0;
		int indice = 0;
		
		for (int i = 0; i < pessoas.length; i++){

			if (pessoas[i].getIdade() > maior){
				maior = pessoas[i].getIdade();
				indice = i;
			}
		}

		System.out.println("\n PESSOA MAIS VELHA: " + pessoas[indice].getNome());

		sc.close();
	}
}
