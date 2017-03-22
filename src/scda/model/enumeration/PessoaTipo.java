package scda.model.enumeration;

public enum PessoaTipo {

	FISICA("F", "Pessoa Física"), JURIDICA("J", "Pessoa Jurídica");

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
