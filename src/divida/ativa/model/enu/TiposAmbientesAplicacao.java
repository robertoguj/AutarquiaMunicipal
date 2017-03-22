package divida.ativa.model.enu;

public enum TiposAmbientesAplicacao {

	PRODUCAO(1, "PRODUÇÃO"),
	HOMOLOGACAO(2, "HOMOLOGAÇÃO"),
	DESENVOLVIMENTO(3, "DESENVOLVIMENTO"),
	TREINAMENTO(4, "TREINAMENTO");
	
	private int codigoTipoAmbienteAplicacao;
	private String tipoAmbienteAplicacao;
	
	public int getCodigoTipoAmbienteAplicacao(){
		return this.codigoTipoAmbienteAplicacao;
	}
	
	public void setCodigoTipoEmissao(int codigoTipoEmissao){
		this.codigoTipoAmbienteAplicacao = codigoTipoEmissao;
	}
	
	private TiposAmbientesAplicacao(int codigoTipoAmbienteAplicacao, String tipoAmbienteAplicacao){
		this.codigoTipoAmbienteAplicacao=codigoTipoAmbienteAplicacao;
		this.tipoAmbienteAplicacao=tipoAmbienteAplicacao;
	}

	public String getTipoAmbienteAplicacao(){
		return this.tipoAmbienteAplicacao;
	}
	
	public void setTipoAmbienteAplicacao(String tipoAmbienteAplicacao){
		this.tipoAmbienteAplicacao = tipoAmbienteAplicacao;
	}
}
