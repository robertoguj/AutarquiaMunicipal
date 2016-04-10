package amc.scda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import amc.scda.business.DividaBusiness;
import amc.scda.controller.application.AbstractController;
import amc.scda.dao.DividaDAOxx;
import amc.scda.entity.Divida;
import amc.scda.entity.Multa;
import amc.scda.entity.Pessoa;

@ManagedBean
@SessionScoped
public class DividaController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 3396296823664993916L;

	private Divida divida;
	
	private Pessoa pessoa;
	
	private List<Divida> lista = null;
	
	private Multa multa;
	
	private DividaDAOxx dividaDAO;

	private int numRegistros;
	
	
	
	
	/*
	
	
	private volatile DividaFacade dividaFacade;

    private LazyDataModelBase<Divida> model =
        new LazyDataModelBase<Divida>(dividaFacade);


    public void setModel(LazyDataModelBase<Divida> model) {
        this.model = model;
    }

    public LazyDataModelBase<Divida> getModel() {
        model.setFacade(dividaFacade);
        return model;
    }

    public DividaFacade getDividaFacade() {
        return dividaFacade;
    }

    public void setUserFacade(DividaFacade dividaFacade) {
        this.dividaFacade = dividaFacade;
        model.setFacade(dividaFacade);
    }
	
	
	*/
	
	
	
	

	public DividaController() {
		resetarCampos();
		total = 0;
	}
	
	public String init() {
		logger.info("Bean execultado! ");
		
		try {
			
			resetarCampos();
			carregarListaDividas();
			
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
		return "DashboardDividas";
	}
	
	public void resetarCampos() {
		this.divida = new Divida();
		this.pessoa = new Pessoa();
		this.multa = new Multa();
		this.dividaDAO = new DividaDAOxx();

	}

	// Business rules



	

	public String carregarListaDividas() throws Exception {
		

		
		 return "DashboardDividas";
	}
	

	public String detalharDivida() {
		
		getDividaDAO().buscaPorId(divida.getId());
		
		return "detalharDivida";
	}
	
	
	
	public String executarDivida() {
		
		try {
			
			DividaBusiness dividaBO = new DividaBusiness();
			dividaBO.emitirCDA();
			
			
			addInfoMessage("Dívida executada com sucesso! ");
		} catch (Exception e) {
			addErrorMessage("Erro ao executar dívida! " + e.getMessage());
		}
		
		
		
		return "detalharDivida";
	}
	

	
	
	
	
	
	
	/*
	@SuppressWarnings("rawtypes")
	public void emitirRelatorioDividas() {

		this.listaDividas = getDividaDAO().consultaPorStatus(divida);
		HashMap paramRel = new HashMap();

		String nomeRelatorio = "";

		gerarRelatorio(nomeRelatorio, paramRel, listaDividas);

	}*/

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}

	public List<Divida> getListaDividas() {
		return dividaDAO.todos();
	}

	
	
	public List<Divida> getCarregarDividasNaoPagas() {
		if (this.lista == null) {
			
			DividaBusiness dividaBO = new DividaBusiness();
			this.lista = dividaBO.getDividasNaoPagas();
		}
		return this.lista;
	}
	
	public List<Divida> getPreInscritas() {
		return dividaDAO.dividasPreInscritas();
	}
	
	public List<Divida> getNaoPagas() {
		return dividaDAO.dividasNaoPagas();
	}
	
	public List<Divida> getEmRecurso() {
		return dividaDAO.dividasEmRecurso();
	}
	
	public List<Divida> getLiquidadas() {
		return dividaDAO.dividasLiquidadas();
	}
	
	public List<Divida> getExecutadas() {
		return dividaDAO.dividasExecutadas();
	}
	
	public List<Divida> getPrescritas() {
		return dividaDAO.dividasPrescritas();
	}


	public DividaDAOxx getDividaDAO() {
		return dividaDAO;
	}

	public void setDividaDAO(DividaDAOxx dividaDAO) {
		this.dividaDAO = dividaDAO;
	}

	

	public int getNumRegistros() {
		/*numRegistros = this.listaDividas.size();*/
		return numRegistros;
	}

	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}



}
