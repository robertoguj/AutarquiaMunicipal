package scda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import scda.model.Multa;
import scda.model.Veiculo;
import scda.repository.Multas;

@ManagedBean
@SessionScoped
public class MultaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MultaController.class);

	private Multa multa;

	private Veiculo veiculo;

	private Multas multas;

	private List<Multa> listaMultas;

	private int valorTotal;

	public MultaController() {

		this.multa = new Multa();
		this.veiculo = new Veiculo();

		this.multas = new Multas();
		this.listaMultas = new ArrayList<Multa>();

	}

	public String consultar() {

		this.listaMultas = multas.todos();
		return "dashboardMultas";

	}
	
	
	public String notificar() {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "dashboardMultas";
	}
	
	
	


}
