package Entidades;

import Enum.Categoria;

public class Carro {
	
	private static int id=1;
	
	private double valor;
	private String ano;
	private Modelo modelo;
	private Marca marca;
	private Categoria categoria;
	private int idCarro;
	private boolean disponivel = true;
	private Cliente cliente = null;
	
	
	
	
	public Carro() {
		
	}
	
	public Carro(double valor, String ano, Modelo modelo, Marca marca,Categoria categoria) {
		this.valor = valor;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.categoria= categoria;
		this.idCarro=id;
		id++;
				
				
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		Carro.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	
	

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public String toString() {
		return "\nId: "+this.idCarro+
				"\nCategoria: "+this.getCategoria()+
				"\nValor: "+this.getValor()+
				"\nAno: "+this.getAno()+
				"\nModelo: "+this.getModelo().getDescricao()+
				"\nMarca: "+this.getMarca().getDescricao()+
				"\nDisponivel? "+this.disponivel;
		
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	
	
	
	

}
