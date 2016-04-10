package amc.scda.entity;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import amc.scda.entity.enums.DividaStatus;

@Entity
@Table(name="dividas")
public class Divida implements Serializable {
	
	private static final long serialVersionUID = -1682006722767720077L;

	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="vl_divida")
	private double valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inscricao")
	private Date dataInscricao;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private DividaStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Pessoa pessoa;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "dividas_multas", joinColumns = { @JoinColumn(name = "divida_id") }, inverseJoinColumns = { @JoinColumn(name = "multa_id") })
	private List<Multa> multas;
	
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

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DividaStatus getStatus() {
		return status;
	}

	public void setStatus(DividaStatus status) {
		this.status = status;
	}

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

}
