package entities;

public class Student {

	public String Name;
	public double grade_1; // Valor máximo 30
	public double grade_2; // Valor máximo 35
	public double grade_3; // Valor máximo 35

	public double finalGrade() {
		return grade_1 + grade_2 + grade_3;
	}

	public String[] result() {

		String[] result = new String[2];
		if (finalGrade() >= 60.00) {
			result[0] = "PASS";
			result[1] = "";
		} else {
			result[0] = "FAILED"; 
			result[1] = "MISSING " + String.format("%.2f", 60.00 - finalGrade()) + " POINTS";
		}

		return result;

	}
}
