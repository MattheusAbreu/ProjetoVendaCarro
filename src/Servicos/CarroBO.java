package Servicos;

import Entidades.Carro;
import Entidades.Marca;
import Entidades.Modelo;
import Enum.Categoria;
import Utils.BancoDeDadosCarros;

public class CarroBO {
	
	public Carro carro;

	public CarroBO(Carro carro) {
		this.carro = carro;		
	}
	
	
	
	public CarroBO(double valor, String ano, Modelo modelo, Marca marca,Categoria categoria) {
		
		this.carro = this.cadastrarCarro(valor, ano, modelo, marca, categoria);
	
		
		
	}
	
	public Carro cadastrarCarro(double valor, String ano, Modelo modelo, Marca marca,Categoria categoria) {
		
		Carro carro = new Carro(valor,ano,modelo,marca,categoria);
		BancoDeDadosCarros.inserirCarro(carro);
		return carro;
		
		
		
		
		
	}



	public Carro getCarro() {
		return this.carro;
	}
	
	
	
	
	
	

}
