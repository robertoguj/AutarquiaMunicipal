package amc.scda.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notificacao")
public class Notificacao {

	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_postagem")
	private Date dataPostagem;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AvisoRecebimento ar;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Divida divida;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public AvisoRecebimento getAr() {
		return ar;
	}

	public void setAr(AvisoRecebimento ar) {
		this.ar = ar;
	}

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}

}
