import java.util.Scanner;
import entities.Pessoas;

/* Problema "dados_pessoas"
 *
 * Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas. 
 * Fazer um programa que calcule e escreva a maior e a menor altura do grupo,
 * a média de altura das mulheres, e o número de homens.
 *
 * Exemplo:
 * Quantas pessoas serao digitadas? 5 
 * Altura da 1a pessoa: 1.70
 * Genero da 1a pessoa: F
 * Altura da 2a pessoa: 1.83
 * Genero da 2a pessoa: M 
 * Altura da 3a pessoa: 1.54 
 * Genero da 3a pessoa: M 
 * Altura da 4a pessoa: 1.61 
 * Genero da 4a pessoa: F 
 * Altura da 5a pessoa: 1.75 
 * Genero da 5a pessoa: F 
 * 
 * Menor altura = 1.54
 * Maior altura = 1.83
 * Media das alturas das mulheres = 1.69 
 * Numero de homens = 2
 *
 */
 
public class dadospessoas {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas? ");
		int N = sc.nextInt();
		
		Pessoas[] pessoas = new Pessoas[N];

		double altura;
		char genero;
			
		for (int i = 0; i < N; i++){
			System.out.print("Altura da "+ (i+1)  +"a pessoa: ");
			altura = sc.nextDouble();
			System.out.print("Genero da "+ (i+1)  +"a pessoa: ");
			genero = sc.next().charAt(0);

			pessoas[i] = new Pessoas(altura, genero);
		}
		
		double maior = 0;
		double menor = 9;
		double media = 0;
		int homens = 0;
		int mulher = 0;

		for (int i = 0; i < pessoas.length; i++){
			
			if (pessoas[i].getAltura() > maior){
				maior = pessoas[i].getAltura(); 
			}  
			if (pessoas[i].getAltura() < menor) {
				menor = pessoas[i].getAltura();
			} 
			

			if (pessoas[i].getGenero() == 'M'){
				homens += 1;
			} else {
				media += pessoas[i].getAltura();
				mulher += 1;
			}
		}
		media = media / mulher;
		
		System.out.println("\nMenor altura = " + menor);
		System.out.println("\nMaior altura = " + maior);
		System.out.println("\nMedia das Alturas das Mulheres = " + media);
		System.out.println("\nNumero de homens = " + homens);

		sc.close();
	}
}
