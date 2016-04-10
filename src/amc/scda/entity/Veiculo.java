package amc.scda.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -8294363857239257771L;

	@Id
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="id_seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="ano_fabricacao")
	private int ano;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="chassi")
	private String chassi;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Pessoa pessoa;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


}
