package Servicos;


import Entidades.Modelo;
import Utils.BancoDeDadosModelos;

public class ModeloBO {
	
	Modelo modelo;
	
	
	public ModeloBO(String desc) {
		this.modelo = this.cadastrarModelo(desc);
		
	}
	
	public ModeloBO(Modelo modelo) {
		this.modelo=modelo;
	}
	
	
	public Modelo cadastrarModelo(String nome) {
		
		Modelo modelo = new Modelo(nome);
		BancoDeDadosModelos.inserirModelo(modelo);
		return modelo;
	}

	
	
	
	public Modelo getModelo() {
		return modelo;
	}
	
	

}
