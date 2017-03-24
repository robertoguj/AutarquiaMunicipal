package divida.ativa.model.enu;

public enum StatusMulta {

	PRESCRITA (1, "Prescrita"),
	NAO_PAGA (2, "Não paga"),
	PRONTA_NOTIFICACAO (3, "Pronta para notificação"),
	NOTIFICADA (4, "Notificada"),
	EM_RECURSO (5, "Em recurso"),
	LIQUIDADA (6, "Liquidada"),
	INSCRITA_EM_DIVIDA (7, "Inscrita em dívida ativa");

	private final int codigoStatus;
	private final String statusMulta;

	private StatusMulta(int codigoStatus, String statusMulta) {
		this.codigoStatus = codigoStatus;
		this.statusMulta = statusMulta;
	}

	public int getCodigoStatus() {
		return codigoStatus;
	}

	public String getStatusMulta() {
		return statusMulta;
	}

}
