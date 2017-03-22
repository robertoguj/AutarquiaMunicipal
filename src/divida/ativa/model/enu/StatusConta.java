package divida.ativa.model.enu;

public enum StatusConta {

	ATIVO("Usu?rio Ativo"), INATIVO("Usu?rio Inativo");

	private final String statusConta;

	private StatusConta(String statusConta) {
		this.statusConta = statusConta;
	}

	public String getStatusConta() {
		return statusConta;
	}

}
