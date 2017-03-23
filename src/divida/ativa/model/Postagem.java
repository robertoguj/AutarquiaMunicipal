package divida.ativa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import divida.ativa.model.enu.StatusPostagem;

@Entity
@Table(name="postagem")
public class Postagem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String numeroAR;
	private Date dataPostagem;
	private StatusPostagem statusPostagem;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postagem_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="aviso_recebimento")
	public String getNumeroAR() {
		return numeroAR;
	}

	public void setNumeroAR(String numeroAR) {
		this.numeroAR = numeroAR;
	}

	@Column(name="status_postagem")
	@Enumerated(EnumType.STRING)
	public StatusPostagem getStatusPostagem() {
		return statusPostagem;
	}

	public void setStatusPostagem(StatusPostagem statusPostagem) {
		this.statusPostagem = statusPostagem;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_postagem")
	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPostagem == null) ? 0 : dataPostagem.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroAR == null) ? 0 : numeroAR.hashCode());
		result = prime * result + ((statusPostagem == null) ? 0 : statusPostagem.hashCode());
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
		Postagem other = (Postagem) obj;
		if (dataPostagem == null) {
			if (other.dataPostagem != null)
				return false;
		} else if (!dataPostagem.equals(other.dataPostagem))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroAR == null) {
			if (other.numeroAR != null)
				return false;
		} else if (!numeroAR.equals(other.numeroAR))
			return false;
		if (statusPostagem != other.statusPostagem)
			return false;
		return true;
	}


}
