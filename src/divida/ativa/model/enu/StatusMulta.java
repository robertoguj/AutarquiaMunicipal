package divida.ativa.model.enu;

public enum StatusMulta {

	PRESCRITA (1, "Multas prescritas"),
	NAO_PAGA (2, "Multas não pagas"),
	PRONTA_NOTIFICACAO (3, "Multas prontas para notificação"),
	NOTIFICADA (4, "Multas notificadas"),
	EM_RECURSO (5, "Multa em recurso"),
	LIQUIDADA (6, "Multas liquidadas"),
	INSCRITA_EM_DIVIDA (7, "Multas inscritas em dívida ativa");

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
