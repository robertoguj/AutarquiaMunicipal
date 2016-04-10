package amc.scda.entity.enums;

public enum DividaStatus {

	PRE_INSCRITA(1, "D�vidas pr�-inscritas"),
	NAO_PAGA(2, "D�vidas n�o pagas"),
	LIQUIDADA(3, "D�vidas liquidadas"),
	EXECUTADA(4, "D�vidas executadas"),
	PRESCRITA(5, "D�vidas prescritas");

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
