package amc.scda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import amc.scda.business.UserBusiness;
import amc.scda.controller.application.AbstractController;
import amc.scda.dao.NamedParams;
import amc.scda.entity.User;
import amc.scda.security.session.SessionContext;
import amc.scda.util.exception.BOException;


@ManagedBean
@SessionScoped
public class UserController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	private EntityManager entityManager;
	
	@ManagedProperty(value="userBO")
	private UserBusiness userBO;

	private User user = new User();
	
	private String confirmarSenha;
	
	private List<User> lista;
	
	private String destinoSalvar;
	
	private String email;
	private String login;
	private String senha;
	
	
	/**
	 * RETORNA USUÁRIO LOGADO
	 */
	
	
	public User getUser() {
		return (User) SessionContext.getInstance().getUsuarioLogado();
	}
	/*
	public String doLogin() {
		try {
			
			logger.info("Tentando logar com usuário " + login);
			User user = userBO.isUsuarioReadyToLogin(login, senha);
			
			if (user == null) {
				addErrorMessage("Login ou Senha inválido, tente novamente !");
				FacesContext.getCurrentInstance().validationFailed();
				return "*";
			}
			
			User user = (User) getUserBO().findByNamedQuery(User.FIND_BY_ID, new NamedParams("id", user.getId())).get(0));
			logger.info("Login efetuado com sucesso");
			SessionContext.getInstance().setAttribute("usuarioLogado", user);
			
			return "/restrito/home.jsf?faces-redirect=true";
			
			
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
			FacesContext.getCurrentInstance().validationFailed();
			e.printStackTrace();
			
			return "*";
		}
	}*/
	
	
	public String doLogout() {
		logger.info("Fazendo logout com usuário " + SessionContext.getInstance().getUsuarioLogado().getUsername());
		
		SessionContext.getInstance().encerrarSessao();
		addInfoMessage("Logout realizado com sucesso! ");
		
		return "/login.jsf?faces-redirect=true";
	}
	
	
	public void solicitarNovaSenha() {

		try {
			getUserBO().gerarNovaSenha();
			addInfoMessage("Nova senha enviada para o email " + email);
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
			FacesContext.getCurrentInstance().validationFailed();
		} 
		
	}
	

	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.user = new User();
		this.user.setAtivo(true);
		return "/publico/usuario.jsf?faces-redirect=true";
	}

	
	public String editar() {
		this.confirmarSenha = this.user.getPassword();
		return "/publico/usuario.jsf?faces-redirect=true";
	}

	
	public String salvar() {
		
		String senha = this.user.getPassword();
		if (!senha.equals(this.confirmarSenha)) {
			addInfoMessage("A senha não foi confirmada corretamente");
			return null;
		}
		
		UserBusiness userBO = new UserBusiness();
		userBO.salvar(this.user);
		
		// Envia email após o cadastramento de um usuário novo
		if (this.destinoSalvar.equals("usuarioSucesso")) {
			try {
				userBO.enviarEmailPosCadastramento(this.user);

			} catch (BOException e) {
				addErrorMessage("Não foi possível enviar o e-mail de cadastro do usuário. Erro: " + e.getMessage());
				return null;
			}
		}
		return this.destinoSalvar;
		
	}
	
	public void excluir() {
		UserBusiness userBO = new UserBusiness();
		userBO.excluir(user);
		this.lista = null;
	}
	
	public void ativar() {
		if (this.user.isAtivo())
			this.user.setAtivo(false);
		else
			this.user.setAtivo(true);
		
		UserBusiness userBO = new UserBusiness();
		userBO.salvar(this.user);
	}
	
	public String excluirSelecionados() {
		try {

			UserBusiness userBO = new UserBusiness();
			userBO.excluirSelecionados();

			addInfoMessage("Usuários selecionados removidos com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
			addErrorMessage("Erro ao excluir usuários selecionados. " + e.getMessage());
		}
		return "dashboardUsuario";
	}

	public void carregarPerfis() {
		try {
			
			UserBusiness userBO = new UserBusiness();
			userBO.carregarPerfis();

			} catch (Exception e) {
				e.printStackTrace();
				addErrorMessage("Erro ao carregar perfis" + e.getMessage());
			}
	
	}


	public List<User> getLista() {
		if (this.lista == null) {
			UserBusiness userBO = new UserBusiness();
			this.lista = userBO.listar();
		}
		return this.lista;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UserBusiness getUserBO() {
		return userBO;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


}
