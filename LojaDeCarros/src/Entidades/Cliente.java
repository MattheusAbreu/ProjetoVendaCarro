package Entidades;

public class Cliente {
	
	private String nome;
	private String cpf;
	private boolean primeiraCompra=true;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isPrimeiraCompra() {
		return primeiraCompra;
	}

	public void setPrimeiraCompra(boolean primeiraCompra) {
		this.primeiraCompra = primeiraCompra;
	}
	
	
	
	

	
}
