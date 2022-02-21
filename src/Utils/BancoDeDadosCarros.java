package Utils;

import java.util.HashMap;
import java.util.Map;

import Entidades.Carro;

public class BancoDeDadosCarros {

	private static Map<Integer, Carro> BANCO_DE_DADOS_CARROS = new HashMap<Integer, Carro>();

	public static boolean inserirCarro(Carro carro) {

		try {

			BANCO_DE_DADOS_CARROS.put(carro.getIdCarro(), carro);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public static Carro buscarCarroId(int id) {

		Carro carro = BANCO_DE_DADOS_CARROS.get(id);

		if (carro != null) {
			return carro;
		} else {
			return null;
		}

	}

	public static void deletaCarroId(int id) {

		BANCO_DE_DADOS_CARROS.remove(id);

	}

	public static void exibirCarrosDisponiveis() {

		for (Map.Entry<Integer, Carro> carros : BancoDeDadosCarros.BANCO_DE_DADOS_CARROS.entrySet()) {
			if(carros.getValue().isDisponivel()==true) {
			System.out.println(carros.getValue());
			}
		}

	}
	
	public static void exibirCarrosVendidos() {

		for (Map.Entry<Integer, Carro> carros : BancoDeDadosCarros.BANCO_DE_DADOS_CARROS.entrySet()) {
			if(carros.getValue().isDisponivel()==false) {
			System.out.println(carros.getValue());
			System.out.println("Vendido para: "+carros.getValue().getCliente().getNome());
			}
		}

	}
}