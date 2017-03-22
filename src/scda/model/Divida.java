package scda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import scda.model.enumeration.StatusDivida;

@Entity
@Table(name="divida")
public class Divida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double valor;
	private Date dataInscricao;
	private StatusDivida statusDivida;
	private Pessoa pessoa;
	private List<Multa> multas;
	
	@Transient
	private Boolean checkboxSelecao=false;

	@Id
	@Column(name="divida_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="valor_divida")
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="data_inscricao")
	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	public StatusDivida getStatusDivida() {
		return statusDivida;
	}

	public void setStatusDivida(StatusDivida statusDivida) {
		this.statusDivida = statusDivida;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="dividas_multas", joinColumns = { @JoinColumn(name="divida_id") }, inverseJoinColumns = { @JoinColumn(name="multa_id") })
	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public Boolean getCheckboxSelecao() {
		return checkboxSelecao;
	}

	public void setCheckboxSelecao(Boolean checkboxSelecao) {
		this.checkboxSelecao = checkboxSelecao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkboxSelecao == null) ? 0 : checkboxSelecao.hashCode());
		result = prime * result + ((dataInscricao == null) ? 0 : dataInscricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((multas == null) ? 0 : multas.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((statusDivida == null) ? 0 : statusDivida.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Divida other = (Divida) obj;
		if (checkboxSelecao == null) {
			if (other.checkboxSelecao != null)
				return false;
		} else if (!checkboxSelecao.equals(other.checkboxSelecao))
			return false;
		if (dataInscricao == null) {
			if (other.dataInscricao != null)
				return false;
		} else if (!dataInscricao.equals(other.dataInscricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multas == null) {
			if (other.multas != null)
				return false;
		} else if (!multas.equals(other.multas))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (statusDivida != other.statusDivida)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}


}
