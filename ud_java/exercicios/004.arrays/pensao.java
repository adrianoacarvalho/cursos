import java.util.Scanner;
import entities.Aluguel;

/* Problema "Pensao"
 *
 * A dona de um pensionato possui dez quartos para alugar 
 * para estudantes, sendo esses quartos identificados 
 * pelos números 0 a 9. Fazer um programa que inicie 
 * com todos os dez quartos vazios, e depois leia uma 
 * quantidade N representando o número de estudantes que vão 
 * alugar quartos (N pode ser de 1 a 10). Em seguida, 
 * registre o aluguel dos N estudantes. Para cada 
 * registro de aluguel, informar o nome e email do 
 * estudante, bem como qual dos quartos ele escolheu 
 * (de 0 a 9). Suponha que seja escolhido um quarto vago. 
 * Ao final, seu programa deve imprimir um relatório de 
 * todas ocupações do pensionato, por ordem de quarto, 
 * conforme exemplo.
 *
 * How many rooms will be rented? 3
 * Rent #1: 
 * Name: Maria Green 
 * Email: maria@gmail.com 
 * Room: 5 
 * Rent #2: 
 * Name: Marco Antonio 
 * Email: marco@gmail.com 
 * Room: 1 
 * Rent #3: 
 * Name: Alex Brown 
 * Email: alex@gmail.com 
 * Room: 8 
 * Busy rooms: 
 * 1: Marco Antonio, marco@gmail.com 
 * 5: Maria Green, maria@gmail.com 
 * 8: Alex Brown, alex@gmail.com
 *
*/

public class pensao {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		Aluguel[] aluguel = new Aluguel[10];

		System.out.print("How many rooms will be rented? ");
		int N = sc.nextInt();	

		String nome;
		String email;
		int room;
			
		for (int i = 0; i < N; i++){
			System.out.println("Rent #"+ (i+1));
			sc.nextLine();
			System.out.println("Name: ");
			nome = sc.nextLine();
			System.out.println("Email: ");
			email = sc.nextLine();
			System.out.println("Room: ");
			room = sc.nextInt();

			aluguel[room] = new Aluguel(nome, email);
		}
		
		System.out.println("Busy rooms:");
		for (int i = 0; i < aluguel.length; i++){

			if (aluguel[i] != null){
				System.out.println(i+": "+aluguel[i].getNome() + ", " + aluguel[i].getEmail()) ;
			}
		}
		
		sc.close();
	}
}
