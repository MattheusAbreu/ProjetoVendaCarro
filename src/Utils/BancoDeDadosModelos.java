package Utils;

import java.util.HashMap;
import java.util.Map;


import Entidades.Modelo;

public class BancoDeDadosModelos {

	public static Map<String, Modelo> BANCO_DE_DADOS_MODELOS = new HashMap<String, Modelo>();

	public static boolean inserirModelo(Modelo modelo) {
		try {
			BANCO_DE_DADOS_MODELOS.put(modelo.getDescricao(), modelo);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public static Modelo buscarModeloDesc(String desc) {

		Modelo modelo = BANCO_DE_DADOS_MODELOS.get(desc);

		if (modelo != null) {

			return modelo;
		} else {
			return null;
		}

	}

	public static boolean buscaModelo(String desc) {
		for (Map.Entry<String, Modelo> modelo : BANCO_DE_DADOS_MODELOS.entrySet()) {

			if (modelo.getValue().getDescricao().toLowerCase().equals(desc)) {
				return true;
			} else {
				return false;

			}
		}
		return false;

	}
}
