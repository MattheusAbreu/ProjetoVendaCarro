package Utils;

public class Validacoes {
	
public static boolean validaCpf(String cpf) {
		
		
		if(cpf.matches("[0-9]*") && cpf.length()==11) {
			return true;
		}
		return false;
	}

}
