package scda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Infracao {

	private String codigoAI;
	private Date dataInfracao;
	private Date horaInfracao;
	private String codigoInfracao;
	private String localInfracao;
	private String descricaoInfracao;
	
	@Column(name="codigo_auto_infracao")
	public String getCodigoAI() {
		return codigoAI;
	}

	public void setCodigoAI(String codigoAI) {
		this.codigoAI = codigoAI;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="data_infracao")
	public Date getDataInfracao() {
		return dataInfracao;
	}

	public void setDataInfracao(Date dataInfracao) {
		this.dataInfracao = dataInfracao;
	}

	@Temporal(TemporalType.TIME)
	@Column(name="hora_infracao")
	public Date getHoraInfracao() {
		return horaInfracao;
	}

	public void setHoraInfracao(Date horaInfracao) {
		this.horaInfracao = horaInfracao;
	}

	@Column(name="codigo_infracao")
	public String getCodigoInfracao() {
		return codigoInfracao;
	}

	public void setCodigoInfracao(String codigoInfracao) {
		this.codigoInfracao = codigoInfracao;
	}

	@Column(name="local_infracao")
	public String getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(String localInfracao) {
		this.localInfracao = localInfracao;
	}

	@Column(name="descricao_infracao")
	public String getDescricaoInfracao() {
		return descricaoInfracao;
	}

	public void setDescricaoInfracao(String descricaoInfracao) {
		this.descricaoInfracao = descricaoInfracao;
	}

}
