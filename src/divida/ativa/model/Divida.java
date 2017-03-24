package divida.ativa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import divida.ativa.model.enu.StatusDivida;

@Entity
@Table(name="divida")
public class Divida implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double valor;
	private Date dataInscricao;
	private StatusDivida statusAtual;
	private Pessoa pessoa;
	private List<Multa> multas;
	private Boolean checkboxSelecao=false;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Column(name="status_atual")
	@Enumerated(EnumType.STRING)
	public StatusDivida getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(StatusDivida statusAtual) {
		this.statusAtual = statusAtual;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="dividas_multas", joinColumns = { @JoinColumn(name="divida_id") }, inverseJoinColumns = { @JoinColumn(name="multa_id") })
	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	@Transient
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
		result = prime * result + ((statusAtual == null) ? 0 : statusAtual.hashCode());
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
		if (statusAtual != other.statusAtual)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}


}
