//package application;

import java.util.Locale;
import java.util.Scanner;

/* Exercicio 2
 * Fazer um programa para ler os dados de um funcionário (nome, salário bruto e imposto).
 * Em seguida, mostrar os dados do funcionário (nome e salário liquido). Em seguida, 
 * aumentar o salário do funcionário com base em uma porcentagem dada (somente o salário 
 * bruto é afetado pela porcentagem) e mostrar novamente os dados do funcionário. Use
 * a classe projetada abaixo.
 *  ---------------------------------------------
 * |       	      Employee		         |
 *  ---------------------------------------------
 * | - Name: string        			 |
 * | - GrossSalary: double 			 |
 * | - Tax: double				 |
 *  ---------------------------------------------
 * | + NetSalary(): double      		 |
 * | + IncreaseSalary(percentage: double): void  |
 *  ---------------------------------------------
 *
 * Exemplo:
 * ---------------------------------------------------------
 * Name: Joao Silva
 * Gross salary: 6000.00
 * Tax: 1000.00
 *
 * Employee: Joao Silva, $ 5000.00
 *
 * Which percentage to increase salary? 10.0
 *
 * Updated data: Joao Silva, $ 5600.00
 */

import entities.Employee;

public class Program {
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	        
		Employee employee = new Employee();

		System.out.print("Name: ");
		employee.name = sc.nextLine();
		System.out.println("");
		System.out.print("Gross salary: ");
		employee.grosssalary = sc.nextDouble();
		System.out.println("");
		System.out.print("Tax: ");
		employee.tax = sc.nextDouble();
		
		System.out.println("Employee: " + employee);

		System.out.print("Which percentage to increase salary: ");
		
		employee.increaseSalary(sc.nextDouble());

		System.out.println("Update data: " + employee);
		
		sc.close();



	}
}
