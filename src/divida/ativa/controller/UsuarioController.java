package divida.ativa.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import divida.ativa.model.Usuario;
import divida.ativa.repository.Usuarios;
import divida.ativa.service.UsuarioService;
import divida.ativa.util.MensagemUtil;
import divida.ativa.util.exception.BOException;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(UsuarioController.class);

	private Usuario usuario;
	
	private Integer total = 0;
	
	private Usuarios usuarios = new Usuarios();
	
	private String confirmarSenha;
	
	private String destinoSalvar;
	
	private List<Usuario> listaUsuarios;
	
	protected List<SelectItem> listaSelecionarPerfil;
	

	public UsuarioController() {
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
		total = 0;
	}

	public String init() {

		logger.info("Bem executado!");

		try {
		resetarCampos();
getListaSelecionarPerfil();
		//	carregarListaSelecionarPerfil();
			
		} catch (Exception e) {
			MensagemUtil.addErrorMessage(e.getMessage());
		}
		return "dashboardUsuario";
	}
	
	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		/*this.user.setAtivo(true);*/
		return "novoUsuario";
	}
	
	public String editar() {
		this.confirmarSenha = this.usuario.getPassword();
		return "editarUsuario";
	}

	public void resetarCampos() {
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	public String salvar() {
		
		String senha = this.usuario.getPassword();
		if (!senha.equals(this.confirmarSenha)) {
			MensagemUtil.addInfoMessage("A senha n?o foi confirmada corretamente");
			return null;
		}
		
		UsuarioService usuarioBusiness = new UsuarioService();
		usuarioBusiness.salvar(this.usuario);
		
		// Envia email ap?s o cadastramento de um usu?rio novo
		if (this.destinoSalvar.equals("usuarioSucesso")) {
			try {
				usuarioBusiness.enviarEmailPosCadastro(usuario);

			} catch (BOException e) {
				MensagemUtil.addErrorMessage("N?o foi poss?vel enviar o e-mail de cadastro do usu?rio. Erro: " + e.getMessage());
				return null;
			}
		}
		return this.destinoSalvar;
		
		/*
		try {

			logger.info("Usu?rio " + user.getNome() + " salvo com sucesso!");

			getUsuarioDAO().incluir(user);
			resetarCampos();
			addInfoMessage("Salvo com sucesso.");
			return "menuUsuario";

		} catch (Exception e) {

			logger.error("Ocorreu um erro ao salvar usu?rio no banco");

			e.printStackTrace();
			addErrorMessage(e.getMessage());
			return "*";
		}
		*/

	}
	
	public void excluir() {
		UsuarioService usuarioBusiness = new UsuarioService();
		usuarioBusiness.excluir(this.usuario);
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

			usuarios.atualizar(usuario);
			MensagemUtil.addInfoMessage("Atualizado com sucesso.");
			
			return "dashboardUsuario";

		} catch (Exception e) {
			MensagemUtil.addErrorMessage(e.getMessage());

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

			resetarCampos();
			usuarios.remover(usuario);
			MensagemUtil.addInfoMessage("Removidos com sucesso.");

		} catch (Exception e) {
			MensagemUtil.addErrorMessage(e.getMessage());
		}
		return "dashboardUsuario";
	}

	public String consultar() {
		this.listaUsuarios = usuarios.todos();
		
		total = listaUsuarios.size();

		if (total == 0) {
			MensagemUtil.addInfoMessage("Nenhum registro foi encontrado.");
		}
		return "dashboardUsuario";
	}

	/*

	public void carregarListaSelecionarPerfil() {
		try {
			listaSelecionarPerfil = new ArrayList<SelectItem>();
			List<Perfil> list = usuarios.listar("description");
				if (list != null && !list.isEmpty()) {
					for (Perfil perfil : list) {
						listaSelecionarPerfil.add(new SelectItem(perfil, perfil
								.getDescription()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				addErrorMessage("Erro ao carregar lista de Perfis" + e.getMessage());
			}
	
	}

	 */

	// GETS E SETS

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
		this.usuario = user;
	}

	public List<Usuario> getListaUsuarios() {
		if (this.listaUsuarios == null) {
			UsuarioService usuarioBusiness = new UsuarioService();
			this.listaUsuarios = usuarioBusiness.listar();
		}
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
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

	public List<SelectItem> getListaSelecionarPerfil() {
		if (this.listaSelecionarPerfil == null) {
			this.listaSelecionarPerfil = new ArrayList<SelectItem>();
			this.listaSelecionarPerfil.add(new SelectItem("ROLE_USER","Usu?rio"));
			this.listaSelecionarPerfil.add(new SelectItem("ROLE_PROJUR","Jur?dico"));
			this.listaSelecionarPerfil.add(new SelectItem("ROLE_ADMIN","Administrador"));
		}
		return listaSelecionarPerfil;
	}

}
