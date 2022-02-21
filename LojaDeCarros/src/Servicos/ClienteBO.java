package Servicos;

import Entidades.Cliente;
import Utils.BancoDeDadosCliente;

public class ClienteBO {
	
	Cliente cliente;
	
	public ClienteBO(Cliente cliente) {
		this.cliente=cliente;
		
	}
	public ClienteBO() {
		
	}
	
	public Cliente cadastrarCliente(String nome, String cpf) {
		
		Cliente cliente = new Cliente(nome,cpf);
		BancoDeDadosCliente.inserirCliente(cliente);
		return cliente;
		
		
		
		
		
		
	}

}
