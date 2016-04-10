package amc.scda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import amc.scda.entity.enums.AvisoRecebimentoStatus;

@Entity
@Table(name="aviso_recebimento")
public class AvisoRecebimento {

	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="numero_ar")
	private String numeroAR;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AvisoRecebimentoStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroAR() {
		return numeroAR;
	}

	public void setNumeroAR(String numeroAR) {
		this.numeroAR = numeroAR;
	}

	public AvisoRecebimentoStatus getStatus() {
		return status;
	}

	public void setStatus(AvisoRecebimentoStatus status) {
		this.status = status;
	}

}
