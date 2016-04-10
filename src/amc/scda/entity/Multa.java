package amc.scda.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import amc.scda.entity.enums.MultaStatus;

@Entity
@Table(name = "multas")
public class Multa implements Serializable {

	private static final long serialVersionUID = 4619526390414386271L;

	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "vl_multa")
	private double valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vencimento")
	private Date dataVencimento;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private MultaStatus status;
	
	@Embedded
	private Infracao infracao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Veiculo veiculo;
	
	@Transient
	private Boolean checkboxSelecao = false;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public MultaStatus getStatus() {
		return status;
	}

	public void setStatus(MultaStatus status) {
		this.status = status;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

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

}
