package amc.scda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import amc.scda.controller.application.AbstractController;
import amc.scda.dao.MultaDAO;
import amc.scda.entity.Multa;
import amc.scda.entity.Veiculo;

@ManagedBean
@SessionScoped
public class MultaController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MultaController.class);

	private Multa multa;

	private Veiculo veiculo;

	private MultaDAO multaDAO;

	private List<Multa> listaMultas;

	private int valorTotal;

	public MultaController() {

		this.multa = new Multa();
		this.veiculo = new Veiculo();

		this.multaDAO = new MultaDAO();
		this.listaMultas = new ArrayList<Multa>();

		total = 0;
	}

	public String consultar() {

		this.listaMultas = getMultaDAO().todos("id");
		total = listaMultas.size();

		if (total == 0) {
			addInfoMessage("Nenhum registro foi encontrado.");
		}

		return "dashboardMultas";
	}
	
	
	public String notificar() {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "dashboardMultas";
	}
	
	
	

	public List<Multa> getNaoPagas() {
		return multaDAO.multasNaoPagas();
	}

	public List<Multa> getProntasParaNotificacao() {
		return multaDAO.multasProntasParaNoticacao();
	}

	public List<Multa> getNotificadas() {
		return multaDAO.multasNotificadas();
	}

	public List<Multa> getEmRecurso() {
		return multaDAO.multasEmRecurso();
	}

	public List<Multa> getLiquidadas() {
		return multaDAO.multasLiquidadas();
	}

	public List<Multa> getExecutadas() {
		return multaDAO.multasExecutadas();
	}

	public List<Multa> getPrescritas() {
		return multaDAO.multasPrescritas();
	}

	public String detalharMulta() {

		getMultaDAO().buscaPorId(multa.getId());
		return "detalharMulta";
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public MultaDAO getMultaDAO() {
		return multaDAO;
	}

	public void setMultaDAO(MultaDAO multaDAO) {
		this.multaDAO = multaDAO;
	}

	public List<Multa> getListaMultas() {
		return listaMultas;
	}

	public void setListaMultas(List<Multa> listaMultas) {
		this.listaMultas = listaMultas;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

}
