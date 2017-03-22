package divida.ativa.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import divida.ativa.model.Divida;
import divida.ativa.model.Multa;
import divida.ativa.model.Pessoa;
import divida.ativa.repository.Dividas;
import divida.ativa.service.DividaService;
import divida.ativa.util.MensagemUtil;

@ManagedBean
@SessionScoped
public class DividaController implements Serializable {

	private static final long serialVersionUID = 3396296823664993916L;

	private static Logger logger = Logger.getLogger(DividaController.class);
	
	private Divida divida;
	
	private Pessoa pessoa;
	
	private List<Divida> lista = null;
	
	private Multa multa;
	
	private Dividas dividas;

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
	}
	
	public String init() {
		logger.info("Bean execultado! ");
		
		try {
			
			resetarCampos();
			carregarListaDividas();
			
		} catch (Exception e) {
			MensagemUtil.addErrorMessage(e.getMessage());
		}
		return "DashboardDividas";
	}
	
	public void resetarCampos() {
		this.divida = new Divida();
		this.pessoa = new Pessoa();
		this.multa = new Multa();

	}

	// Business rules



	

	public String carregarListaDividas() throws Exception {
		

		
		 return "DashboardDividas";
	}
	

	public String detalharDivida() {
		
		//getDividaDAO().buscaPorID(divida.getId());
		
		return "detalharDivida";
	}
	
	
	
	public String executarDivida() {
		
		try {
			
			DividaService dividaBO = new DividaService();
			dividaBO.emitirCDA();
			
			MensagemUtil.addInfoMessage("D?vida executada com sucesso! ");
			
		} catch (Exception e) {
			MensagemUtil.addErrorMessage("Erro ao executar d?vida! " + e.getMessage());
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
