package divida.ativa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="notificacao")
public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Divida divida;
	private Postagem postagem;
	
	@Id
	@Column(name="notificacao_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="postagem_id")
	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="divida_id")
	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divida == null) ? 0 : divida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((postagem == null) ? 0 : postagem.hashCode());
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
		Notificacao other = (Notificacao) obj;
		if (divida == null) {
			if (other.divida != null)
				return false;
		} else if (!divida.equals(other.divida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (postagem == null) {
			if (other.postagem != null)
				return false;
		} else if (!postagem.equals(other.postagem))
			return false;
		return true;
	}

}
