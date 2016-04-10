package amc.scda.entity.enums;

public enum ContaStatus {

	ATIVO("Usu�rio Ativo"), INATIVO("Usu�rio Inativo");

	private final String statusConta;

	private ContaStatus(String statusConta) {
		this.statusConta = statusConta;
	}

	public String getStatusConta() {
		return statusConta;
	}

}
