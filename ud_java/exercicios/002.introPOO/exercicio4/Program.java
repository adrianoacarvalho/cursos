//package application;

import java.util.Locale;
import java.util.Scanner;

/* Exercicio 4
 * Faça um programa para ler a cotação do dolar, e depois
 * um valor em dólares a ser comprado por uma pessoa em
 * reais. Informar quantos reais a pessoa vai pagar pelos
 * dólares, considerando ainda que a pessoa terá que pagar
 * 6% de IOF sobre o valor em dólar. Criar uma classe
 * CurrencyConverter para ser responsável pelos cálculos.
 *
 * Exemplo:
 * ---------------------------------------------------------
 * What is the dollar price? 3.10
 * How many dollars will be bought? 200.00
 * Amount to be paid in reais = 657.20
 */

import util.CurrencyConverter;

public class Program {
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is the dollar price? ");
		double price = sc.nextDouble();
		System.out.println("How many dollars will be bought? "); 
		double amount = sc.nextDouble();

		System.out.println("Amount to be paid in reais = " + String.format("%.2f", CurrencyConverter.usdToBrl(price, amount)));

		sc.close();
	}
}
