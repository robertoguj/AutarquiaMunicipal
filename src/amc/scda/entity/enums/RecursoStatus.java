package amc.scda.entity.enums;

public enum RecursoStatus {
	
	AGUARDANDO_RECURSO(1, "Aguardando recurso"), DEFERIDO(2, "Deferido"),
	INDEFERIDO(3, "Indeferido");
	
	private int codigoStatus;
	private String statusRecurso;
	
	private RecursoStatus(int codigoStatus, String statusRecurso) {
		this.codigoStatus = codigoStatus;
		this.statusRecurso = statusRecurso;
	}

	public int getCodigoStatus() {
		return codigoStatus;
	}

	public String getStatusRecurso() {
		return statusRecurso;
	}

}
