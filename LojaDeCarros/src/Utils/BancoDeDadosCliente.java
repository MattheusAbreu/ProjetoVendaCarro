package Utils;

import java.util.HashMap;
import java.util.Map;

import Entidades.Cliente;

public class BancoDeDadosCliente {
	
	public static Map<String,Cliente> BANCO_DE_DADOS_CLIENTES = new HashMap<String,Cliente>();
	
	
	public static boolean inserirCliente(Cliente cliente) {
		try {
			BANCO_DE_DADOS_CLIENTES.put(cliente.getCpf(),cliente);
			return true;
			
		} catch (Exception e) {
		 return false;
		}
		
		
		
		
		
		
		
	}
	
	public static Cliente buscarClienteCPF(String cpf) {
		
		Cliente cliente = BANCO_DE_DADOS_CLIENTES.get(cpf);
		
		if(cliente!= null) {
			
			return cliente;
		}
		else {
			return null;
		}
		
		
		
		
	}

		public static boolean buscarCpf(String cpf) {
		
		for (Map.Entry<String, Cliente> cliente: BancoDeDadosCliente.BANCO_DE_DADOS_CLIENTES.entrySet()) {

			if (cliente.getValue().getCpf().equals(cpf)) {
				return true;
			}

		}
		return false;
		
		
	}	

}
