//package application;

import java.util.Locale;
import java.util.Scanner;

/* Exercicio 3
 * Fazer um programa para ler o nome de um aluno e as três notas que ele obteve nos três
 * trimestres do ano (primeiro trimestre vale 30 e o segundo e o terceiro valem 35 cada).
 * Ao final, mostrar qual a nota final do aluno no ano. Dizer também se o aluno está 
 * aprovado (PASS) ou não (FAILED) e, em caso negativo, quantos pontos faltam para o 
 * aluno obter o mínimo para ser aprovado (que é 60% da nota). Você deve criar uma classe
 * Student para resolver este problema.
 *
 * Exemplo:
 * ---------------------------------------------------------
 * Entrada:				Saida:
 * Alex Green				FINAL GRADE = 90.00
 * 27.00				PASS
 * 31.00
 * 32.00
 *
 * 
 * Entrada:				Saida:
 * Alex Green				FINAL GRADE = 52.00
 * 17.00				FAILED
 * 20.00				MISSING 8.00 POINTS
 * 15.00
 *
 */

import entities.Student;

public class Program {
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	        
		Student student = new Student();

		student.Name = sc.nextLine();

		student.grade_1 = sc.nextDouble();
		student.grade_2 = sc.nextDouble();
		student.grade_3 = sc.nextDouble();

		System.out.println("FINAL GRADE = " + String.format("%.2f", student.finalGrade()));
		String[] result = student.result();
		System.out.println(result[0]);
		System.out.println(result[1]);

		sc.close();



	}
}
