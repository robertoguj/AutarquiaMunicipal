package amc.scda.business;

import java.util.List;

import amc.scda.controller.application.AbstractController;
import amc.scda.dao.DividaDAO;
import amc.scda.dao.factory.DAOFactory;
import amc.scda.entity.Divida;
import amc.scda.entity.enums.DividaStatus;
import amc.scda.util.Funcoes;

public class DividaBusiness extends AbstractController {
	
	private DividaDAO dividaDAO;

	public DividaBusiness() {
		super();
		setDividaDAO(DAOFactory.criarDividaDAO());
	}
	
	
	
	
	
	
	
	
	public void emitirCDA() {
		
		
		
		
		
	}
	
	
	
	public void emitirPeticaoInicial() {
		
		
		
		
		
	}
	
	
	
	
	public void validaLiquidacaoDivida(Divida divida) throws Exception {
		
		try {
			
			if ((divida.getStatus() == DividaStatus.NAO_PAGA) || (divida.getStatus() == DividaStatus.EXECUTADA)) {
				divida.setStatus(DividaStatus.LIQUIDADA);
				
				addInfoMessage("D�vida liquidada com sucesso! ");
				
			} else {
				addErrorMessage("Opera��o n�o permitida. O status atual da d�vida " + divida.getStatus() + " n�o permite a liquida��o da d�vida.");
			}
			
		} catch (Exception e) {

			throw new Exception ("N�o foi poss�vel liquidar d�vida. Erro: " + e.getMessage());
		}

	}
	
	
	
	public void validaPrescricaoDivida(Divida divida) {
	
		/**
		 * Criar rotina para prescri��o da d�vida 
		 */
		
		
		
		if (Funcoes.getDataAtual() != null) {
			
		}
		
		
	}
	
	
	
	
	public void validaExecucaoDivida(Divida divida) throws Exception {
		
		try {
			
			if (divida.getStatus() == DividaStatus.NAO_PAGA) {
				divida.setStatus(DividaStatus.EXECUTADA);

				addInfoMessage("D�vida liquidada com sucesso! ");
				
			} else {
				addErrorMessage("Opera��o n�o permitida. O status atual da d�vida " + divida.getStatus() + " n�o permite a execu��o da d�vida.");
			}
			
		} catch (Exception e) {
			
			throw new Exception("N�o foi poss�vel executar d�vida. Erro: " + e.getMessage());
		}
		
	}
	
	
	
	public List<Divida> getDividasNaoPagas() {
		return dividaDAO.dividasNaoPagas();
	}
	
	public DividaDAO getDividaDAO() {
		return dividaDAO;
	}

	public void setDividaDAO(DividaDAO dividaDAO) {
		this.dividaDAO = dividaDAO;
	}

}
