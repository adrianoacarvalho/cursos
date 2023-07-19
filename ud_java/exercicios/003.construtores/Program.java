//package application;

import java.util.Locale;
import java.util.Scanner;

/* Exercicio 1
 * 
 * Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o nome do 
 * titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a conta. Este valor de depósito 
 * inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a depositar no momento de abrir sua 
 * conta, o depósito inicial não será feito e o saldo inicial da conta será, naturalmente, zero.
 * Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser alterado. Já 
 * o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasião de casamento, por 
 * exemplo). 
 * Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger 
 * isso. O saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para cada saque 
 * realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo não for 
 * suficiente para realizar o saque e/ou pagar a taxa.
 * Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não 
 * informado o valor de depósito inicial. Em seguida, realizar um depósito e depois um saque, sempre 
 * mostrando os dados da conta após cada operação. 
 *  
 * Exemplo 1:
 * ---------------------------------------------------------
 * Enter account number: 8532
 * Enter account holder: Alex Green
 * Is there na initial deposit (y/n)? y
 * Enter initial deposit value: 500.00
 * Account data:
 * Account 8532, Holder: Alex Green, Balance: $ 500.00
 * Enter a deposit value: 200.00
 * Updated account data:
 * Account 8532, Holder: Alex Green, Balance: $ 700.00
 * Enter a withdraw value: 300.00
 * Updated account data:
 * Account 8532, Holder: Alex Green, Balance: $ 395.00
 *
 * Exemplo 2:
 * ---------------------------------------------------------
 * Enter account number: 7801
 * Enter account holder: Maria Brown
 * Is there na initial deposit (y/n)? n
 * Account data:
 * Account 7801, Holder: Maria Brown, Balance: $ 0.00
 * Enter a deposit value: 200.00
 * Updated account data:
 * Account 7801, Holder: Maria Brown, Balance: $ 200.00
 * Enter a withdraw value: 198.00
 * Updated account data:
 * Account 7801, Holder: Maria Brown, Balance: $ -3.00
 */

import entities.Account;

public class Program {
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	        
		System.out.println("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.println("Enter account holder: ");
		String name = sc.nextLine();
		
		System.out.println("Is there an initial deposit (y/n)? ");
		char initial = sc.next().charAt(0);
		
		Account account;
		if (initial == 'y') {
			System.out.print("Enter initial deposit value: ");
			double deposit = sc.nextDouble();
			account = new Account(number, name, deposit);	
		} else {
			account = new Account(number, name);
		}
		

		System.out.println("Account Data:");
		System.out.println(account);				
		System.out.println("Enter a deposit value: ");
		account.deposit(sc.nextDouble());
		System.out.println("Updated account data:");
		System.out.println(account);
		System.out.println("Enter a withdraw value: ");
		account.withdraw(sc.nextDouble());
		System.out.println("Updated account data:");
		System.out.println(account);

		sc.close();



	}
}