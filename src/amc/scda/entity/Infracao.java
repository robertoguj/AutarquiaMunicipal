package amc.scda.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Infracao {

	@Column(name="id_auto_infracao")
	private String idAutoInfracao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_infracao")
	private Date dataInfracao;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hr_infracao")
	private Date horaInfracao;
	
	@Column(name="codigo_infracao")
	private String codigoInfracao;
	
	@Column(name="local_infracao")
	private String localInfracao;

	@Column(name="descricao_infracao")
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

	public Date getHoraInfracao() {
		return horaInfracao;
	}

	public void setHoraInfracao(Date horaInfracao) {
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
