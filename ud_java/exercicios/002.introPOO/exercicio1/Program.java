//package application;

import java.util.Locale;
import java.util.Scanner;

/* Exercicio 1
 * Fazer um programa para ler os valores da largura e altura
 * de um retângulo. Em seguida, mostrar na tela o valor de sua
 * área, perímetro e diagonal. Usar uma classe como mostrado
 * abaixo.
 *  -----------------------
 * |     Rectangle         |
 *  -----------------------
 * | - Width: double       |
 * | - Height: double      |
 *  -----------------------
 * | + Area(): double      |
 * | + Perimeter(): double | 
 * | + Diagonal(): double  |
 *  -----------------------
 *
 * Exemplo:
 * ---------------------------------------------------------
 * Enter rectangle width and height:
 * 3.00
 * 4.00
 * AREA = 12.00
 * PERIMETER = 14.00
 * DIAGONAL = 5.00
 *
 */

import entities.Rectangle;

public class Program {
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	        
		Rectangle retangulo = new Rectangle();

		System.out.println("Enter rectangle width and height: ");

		retangulo.width = sc.nextDouble();
		retangulo.height = sc.nextDouble();

		System.out.println("AREA = " + String.format("%.2f", retangulo.area()));
		System.out.println("PERIMETER = " + String.format("%.2f", retangulo.perimeter()));
		System.out.println("DIAGONAL = " + String.format("%.2f", retangulo.diagonal()));

		sc.close();



	}
}
