package amc.scda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import amc.scda.business.UserBusiness;
import amc.scda.controller.application.AbstractController;
import amc.scda.dao.RoleDAO;
import amc.scda.dao.UsuarioDAO;
import amc.scda.entity.Role;
import amc.scda.entity.User;
import amc.scda.util.exception.BOException;

@ManagedBean
@SessionScoped
public class UsuarioController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(UsuarioController.class);

	private User user;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private RoleDAO perfilDAO = new RoleDAO();
	
	private String confirmarSenha;
	
	private String destinoSalvar;
	
	private List<User> listaUsuarios;
	
	protected List<SelectItem> listaPerfilSelect = new ArrayList<SelectItem>();
	

	public UsuarioController() {
		this.user = new User();
		this.listaUsuarios = new ArrayList<User>();
		total = 0;
	}

	public String init() {

		logger.info("Bem executado!");

		try {
		resetarCampos();
		carregarListaPerfilSelect();
			
		} catch (Exception e) {
			addErrorMessage(e.getMessage());
		}
		return "dashboardUsuario";
	}
	
	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.user = new User();
		/*this.user.setAtivo(true);*/
		return "novoUsuario";
	}
	
	public String editar() {
		this.confirmarSenha = this.user.getPassword();
		return "editarUsuario";
	}

	public void resetarCampos() {
		this.user = new User();
		this.listaUsuarios = new ArrayList<User>();
	}

	public String salvar() {
		
		String senha = this.user.getPassword();
		if (!senha.equals(this.confirmarSenha)) {
			addInfoMessage("A senha não foi confirmada corretamente");
			return null;
		}
		
		UserBusiness usuarioBusiness = new UserBusiness();
		usuarioBusiness.salvar(this.user);
		
		// Envia email após o cadastramento de um usuário novo
		if (this.destinoSalvar.equals("usuarioSucesso")) {
			try {
				usuarioBusiness.enviarEmailPosCadastramento(this.user);

			} catch (BOException e) {
				addErrorMessage("Não foi possível enviar o e-mail de cadastro do usuário. Erro: " + e.getMessage());
				return null;
			}
		}
		return this.destinoSalvar;
		
		/*
		try {

			logger.info("Usuário " + user.getNome() + " salvo com sucesso!");

			getUsuarioDAO().incluir(user);
			resetarCampos();
			addInfoMessage("Salvo com sucesso.");
			return "menuUsuario";

		} catch (Exception e) {

			logger.error("Ocorreu um erro ao salvar usuário no banco");

			e.printStackTrace();
			addErrorMessage(e.getMessage());
			return "*";
		}
		*/

	}
	
	public void excluir() {
		UserBusiness usuarioBusiness = new UserBusiness();
		usuarioBusiness.excluir(this.user);
		this.listaUsuarios = null;
	}
	
	/*public void ativar() {
		if (this.user.isAtivo())
			this.user.setAtivo(false);
		else
			this.user.setAtivo(true);
		
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
		usuarioBusiness.salvar(this.user);
	}*/

	public String atualizar() {
		try {

			getUsuarioDAO().atualizar(user);
			addInfoMessage("Atualizado com sucesso.");
			return "dashboardUsuario";

		} catch (Exception e) {
			e.printStackTrace();
			addErrorMessage(e.getMessage());
			return "*";
		}
	}

	/*
	public void excluir() {
		try {

			getUsuarioDAO().excluir(user.getId());
			resetarCampos();
			addInfoMessage("Removido com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
			addErrorMessage(e.getMessage());
		}
	}*/
	
	public String cancelar() {
		resetarCampos();
		return "dashboardUsuario";
	}

	public String excluirSelecao() {
		try {

			for (User user : listaUsuarios) {
				if (user.getCheckboxSelecao()) {
					getUsuarioDAO().excluir(user.getId());
				}
			}
			resetarCampos();
			getUsuarioDAO().todos("username");
			addInfoMessage("Removidos com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
			addErrorMessage(e.getMessage());
		}
		return "dashboardUsuario";
	}

	public String consultar() {
		this.listaUsuarios = getUsuarioDAO().todos("id");
		total = listaUsuarios.size();

		if (total == 0) {
			addInfoMessage("Nenhum registro foi encontrado.");
		}
		return "dashboardUsuario";
	}

	public void carregarListaPerfilSelect() {
		try {
			listaPerfilSelect = new ArrayList<SelectItem>();
			List<Role> list = getPerfilDAO().todos("description");
				if (list != null && !list.isEmpty()) {
					for (Role perfil : list) {
						listaPerfilSelect.add(new SelectItem(perfil, perfil
								.getDescription()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				addErrorMessage("Erro ao carregar lista de Perfis" + e.getMessage());
			}
	
	}

	

	// GETS E SETS

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListaUsuarios() {
		if (this.listaUsuarios == null) {
			UserBusiness usuarioBusiness = new UserBusiness();
			this.listaUsuarios = usuarioBusiness.listar();
		}
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public RoleDAO getPerfilDAO() {
		return perfilDAO;
	}

	public void setPerfilDAO(RoleDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
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

	public List<SelectItem> getListaPerfilSelect() {
		return listaPerfilSelect;
	}

	public void setListaPerfilSelect(List<SelectItem> listaPerfilSelect) {
		this.listaPerfilSelect = listaPerfilSelect;
	}

}
