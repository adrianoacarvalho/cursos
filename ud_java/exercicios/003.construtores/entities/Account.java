package entities;

public class Account {

	private int number;
	private String holder;
	private double balance;
	private double tax = 5.00;
	

	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public Account(int number, String holder, double balance) {
		this.number = number;
		this.holder = holder;
		deposit(balance);
	}
	
	public int getNumber() {
		return this.number;
	}

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String holder){
		this.holder = holder;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double value) {
		this.balance += value;
	}

	public void withdraw(double value) {
		this.balance -= (value + tax);
	}

	public String toString(){
		return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f", balance);
	}
}
