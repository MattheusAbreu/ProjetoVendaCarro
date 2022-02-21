package Utils;

import java.util.HashMap;
import java.util.Map;

import Entidades.Marca;

public class BancoDeDadosMarca {

	public static Map<String, Marca> BANCO_DE_DADOS_MARCAS = new HashMap<String, Marca>();

	public static boolean inserirMarca(Marca marca) {
		try {
			BANCO_DE_DADOS_MARCAS.put(marca.getDescricao(), marca);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public static Marca buscarMarcaDesc(String desc) {

		Marca marca = BANCO_DE_DADOS_MARCAS.get(desc);

		if (marca != null) {

			return marca;
		} else {
			return null;
		}

	}

	public static boolean buscaMarca(String desc) {
		for (Map.Entry<String, Marca> marca : BANCO_DE_DADOS_MARCAS.entrySet()) {

			if (marca.getValue().getDescricao().toLowerCase().equals(desc)) {
				return true;
			} else {
				return false;

			}
		}
		return false;

	}
}
