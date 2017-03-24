package divida.ativa.model.enu;

public enum StatusDivida {

	PRE_INSCRITA(1, "Pré-inscrita"),
	NAO_PAGA(2, "Não paga"),
	LIQUIDADA(3, "Liquidada"),
	EXECUTADA(4, "Execultada"),
	PRESCRITA(5, "Prescrita"),
	EM_RECURSO(5, "Em recurso");

	private final int codigoStatus;
	private final String statusDivida;

	private StatusDivida(int codigoStatus, String statusDivida) {
		this.codigoStatus = codigoStatus;
		this.statusDivida = statusDivida;
	}

	public int getCodigoStatus() {
		return codigoStatus;
	}
	
	public String getStatusDivida() {
		return statusDivida;
	}
	
}
