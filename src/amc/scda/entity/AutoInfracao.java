package amc.scda.entity;

import java.util.Date;

public class AutoInfracao {

	private String idAutoInfracao;
	private Date dataInfracao;
	private String horaInfracao;
	private String codigoInfracao;
	private String localInfracao;
	private String descricaoInfracao;

	public String getIdAutoInfracao() {
		return idAutoInfracao;
	}

	public void setIdAutoInfracao(String idAutoInfracao) {
		this.idAutoInfracao = idAutoInfracao;
	}

	public Date getDataInfracao() {
		return dataInfracao;
	}

	public void setDataInfracao(Date dataInfracao) {
		this.dataInfracao = dataInfracao;
	}

	public String getHoraInfracao() {
		return horaInfracao;
	}

	public void setHoraInfracao(String horaInfracao) {
		this.horaInfracao = horaInfracao;
	}

	public String getCodigoInfracao() {
		return codigoInfracao;
	}

	public void setCodigoInfracao(String codigoInfracao) {
		this.codigoInfracao = codigoInfracao;
	}

	public String getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(String localInfracao) {
		this.localInfracao = localInfracao;
	}

	public String getDescricaoInfracao() {
		return descricaoInfracao;
	}

	public void setDescricaoInfracao(String descricaoInfracao) {
		this.descricaoInfracao = descricaoInfracao;
	}

}
