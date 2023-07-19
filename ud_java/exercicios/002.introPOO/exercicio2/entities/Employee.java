package entities;

public class Employee {

	public String name;
	public double grosssalary;
	public double tax;

	public double netSalary() {
		return grosssalary - tax;
	}
	
	public void increaseSalary(double percentage) {
		grosssalary = grosssalary * (1 + (percentage/100));
	}

	public String toString(){
		return name + ", $ " + String.format("%.2f", netSalary());
	}
}
