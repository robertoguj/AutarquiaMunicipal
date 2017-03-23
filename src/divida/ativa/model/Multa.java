package divida.ativa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import divida.ativa.model.enu.StatusMulta;

@Entity
@Table(name="multa")
public class Multa implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private double valor;
	private Date dataVencimento;
	private StatusMulta statusMulta;
	private Infracao infracao;
	private Veiculo veiculo;
	
	@Transient
	private Boolean checkboxSelecao=false;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="multa_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "valor_multa")
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Column(name="status_multa")
	@Enumerated(EnumType.STRING)
	public StatusMulta getStatusMulta() {
		return statusMulta;
	}

	public void setStatusMulta(StatusMulta statusMulta) {
		this.statusMulta = statusMulta;
	}

	@Embedded
	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="veiculo_id")
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((infracao == null) ? 0 : infracao.hashCode());
		result = prime * result + ((statusMulta == null) ? 0 : statusMulta.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		Multa other = (Multa) obj;
		if (checkboxSelecao == null) {
			if (other.checkboxSelecao != null)
				return false;
		} else if (!checkboxSelecao.equals(other.checkboxSelecao))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infracao == null) {
			if (other.infracao != null)
				return false;
		} else if (!infracao.equals(other.infracao))
			return false;
		if (statusMulta != other.statusMulta)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

}
