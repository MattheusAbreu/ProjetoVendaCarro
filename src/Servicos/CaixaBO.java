package Servicos;

import Entidades.Caixa;

public class CaixaBO {
	
	Caixa caixa;
	
	public CaixaBO(Caixa caixa) {
		this.caixa=caixa;
	}
	
	
	public CaixaBO() {
	
	}


	public void realizarVenda(double valor) {
		
		Caixa.setValorEmCaixa(Caixa.getValorEmCaixa()+valor);
		
		
	}
	
	public void realizarVenda(double valor,double desconto) {
		
		Caixa.setValorEmCaixa(Caixa.getValorEmCaixa()+(valor-(valor*desconto)));
		
		
	}

}
