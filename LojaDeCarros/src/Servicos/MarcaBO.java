package Servicos;

import Entidades.Marca;
import Utils.BancoDeDadosMarca;

public class MarcaBO {
	
	Marca marca;
	
	public MarcaBO(String desc) {
		this.marca = this.cadastrarMarca(desc);
		
	}
	
	public MarcaBO(Marca marca) {
		this.marca=marca;
	}
	
	
	public Marca cadastrarMarca(String nome) {
		
		Marca marca = new Marca(nome);
		BancoDeDadosMarca.inserirMarca(marca);
		return marca;
	}

	
	
	
	public Marca getMarca() {
		return marca;
	}

	
	
	

}
