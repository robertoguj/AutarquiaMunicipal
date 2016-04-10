package amc.scda.entity.enums;

public enum ContaStatus {

	ATIVO("Usuário Ativo"), INATIVO("Usuário Inativo");

	private final String statusConta;

	private ContaStatus(String statusConta) {
		this.statusConta = statusConta;
	}

	public String getStatusConta() {
		return statusConta;
	}

}
