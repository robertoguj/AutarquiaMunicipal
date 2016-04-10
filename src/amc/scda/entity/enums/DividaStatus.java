package amc.scda.entity.enums;

public enum DividaStatus {

	PRE_INSCRITA(1, "Dívidas pré-inscritas"),
	NAO_PAGA(2, "Dívidas não pagas"),
	LIQUIDADA(3, "Dívidas liquidadas"),
	EXECUTADA(4, "Dívidas executadas"),
	PRESCRITA(5, "Dívidas prescritas");

	private final int codigoStatus;
	private final String statusDivida;

	private DividaStatus(int codigoStatus, String statusDivida) {
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
