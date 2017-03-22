package divida.ativa.service;

import divida.ativa.model.Divida;
import divida.ativa.model.enu.StatusDivida;
import divida.ativa.util.Funcoes;

public class DividaService {
	

	
	
	
	
	
	
	
	public void emitirCDA() {
		
		
		
		
		
	}
	
	
	
	public void emitirPeticaoInicial() {
		
		
		
		
		
	}
	
	
	
	
	public void validaLiquidacaoDivida(Divida divida) throws Exception {
			
			if ((divida.getStatusDivida() == StatusDivida.NAO_PAGA) || (divida.getStatusDivida() == StatusDivida.EXECUTADA)) {
				divida.setStatusDivida(StatusDivida.LIQUIDADA);
			}
	}
	
	
	
	public void validaPrescricaoDivida(Divida divida) {
	
		/**
		 * Criar rotina para prescri豫o da d�vida 
		 */
		
		
		
		if (Funcoes.getDataAtual() != null) {
			
		}
		
		
	}
	
	
	
	
	public void validaExecucaoDivida(Divida divida) throws Exception {

		if (divida.getStatusDivida() == StatusDivida.NAO_PAGA) {
				divida.setStatusDivida(StatusDivida.EXECUTADA);
			}
					
	}
	

}
