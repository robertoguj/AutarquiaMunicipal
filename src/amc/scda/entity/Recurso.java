package amc.scda.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import amc.scda.entity.enums.RecursoStatus;

@Entity
@Table(name="recurso")
public class Recurso {
	
	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura_processo")
	private Date dataAberturaProcesso;
	
	@Column(name="nu_processo")
	private String numeroProcesso;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private RecursoStatus status;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Multa multa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAberturaProcesso() {
		return dataAberturaProcesso;
	}

	public void setDataAberturaProcesso(Date dataAberturaProcesso) {
		this.dataAberturaProcesso = dataAberturaProcesso;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public RecursoStatus getStatus() {
		return status;
	}

	public void setStatus(RecursoStatus status) {
		this.status = status;
	}

}
