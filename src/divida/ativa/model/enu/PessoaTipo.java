package divida.ativa.model.enu;

public enum PessoaTipo {

	FISICA("F", "Pessoa F?sica"), JURIDICA("J", "Pessoa Jur?dica");

	private final String id;

	private final String pessoaTipo;

	private PessoaTipo(String id, String pessoaTipo) {
		this.id = id;
		this.pessoaTipo = pessoaTipo;
	}

	public String getPessoaTipo() {
		return pessoaTipo;
	}

	public String getId() {
		return id;
	}

}
