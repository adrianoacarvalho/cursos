package entities;

public class Pessoas {

	private String nome;
	private int idade;
	private double altura;
        private char genero;	

	public Pessoas(String nome, int idade, double altura) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}
	
	public Pessoas(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		this.altura = 0;
	}

	public Pessoas(double altura, char genero) {
		this.altura = altura;
		this.genero = genero;
	}

	public int getIdade() {
		return this.idade;
	}

	public double getAltura() {
		return this.altura;
	}

	public String getNome(){
		return this.nome;
	}

	public char getGenero(){
		return this.genero;
	}
}
