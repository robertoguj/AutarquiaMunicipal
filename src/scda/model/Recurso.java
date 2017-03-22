package scda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import scda.model.enumeration.StatusRecurso;

@Entity
@Table(name="recurso")
public class Recurso implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String numeroProcesso;
	private Date aberturaProcesso;
	private StatusRecurso statusRecurso;
	private Multa multa;

	@Id
	@Column(name="recurso_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="data_abertura_processo")
	public Date getAberturaProcesso() {
		return aberturaProcesso;
	}

	public void setAberturaProcesso(Date aberturaProcesso) {
		this.aberturaProcesso = aberturaProcesso;
	}

	@Column(name="numero_processo")
	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	@Column(name="status_recurso")
	@Enumerated(EnumType.STRING)
	public StatusRecurso getStatusRecurso() {
		return statusRecurso;
	}

	public void setStatusRecurso(StatusRecurso statusRecurso) {
		this.statusRecurso = statusRecurso;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="multa_id")
	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aberturaProcesso == null) ? 0 : aberturaProcesso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((multa == null) ? 0 : multa.hashCode());
		result = prime * result + ((numeroProcesso == null) ? 0 : numeroProcesso.hashCode());
		result = prime * result + ((statusRecurso == null) ? 0 : statusRecurso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recurso other = (Recurso) obj;
		if (aberturaProcesso == null) {
			if (other.aberturaProcesso != null)
				return false;
		} else if (!aberturaProcesso.equals(other.aberturaProcesso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multa == null) {
			if (other.multa != null)
				return false;
		} else if (!multa.equals(other.multa))
			return false;
		if (numeroProcesso == null) {
			if (other.numeroProcesso != null)
				return false;
		} else if (!numeroProcesso.equals(other.numeroProcesso))
			return false;
		if (statusRecurso != other.statusRecurso)
			return false;
		return true;
	}

}
