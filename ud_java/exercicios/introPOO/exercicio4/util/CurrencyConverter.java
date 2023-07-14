package util;

public class CurrencyConverter {
	public static final double IOF = 0.06; //6%

	public static double usdToBrl(double price, double dollar) {
		double total = price * dollar;
		return total *  (1 + IOF);  
	}
}
