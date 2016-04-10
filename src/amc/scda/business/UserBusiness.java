package amc.scda.business;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import amc.scda.dao.NamedParams;
import amc.scda.dao.RoleDAO;
import amc.scda.dao.UserDAO;
import amc.scda.dao.factory.DAOFactory;
import amc.scda.entity.AbstractEntity;
import amc.scda.entity.Role;
import amc.scda.entity.User;
import amc.scda.util.EmailUtil;
import amc.scda.util.MensagemUtil;
import amc.scda.util.exception.BOException;
import amc.scda.util.exception.DAOException;
import amc.scda.util.exception.UtilException;


public class UserBusiness {
	
	private UserDAO userDAO;
	
	private RoleDAO roleDAO;
	
	private List<User> lista;
	
	private static Logger logger = Logger.getLogger(UserBusiness.class);
	
	protected List<SelectItem> listaPerfis = new ArrayList<SelectItem>();
	
	private EntityManager entityManager;
	
	public UserBusiness() {
		this.userDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public void salvar(User user) {
		
		Integer codigo = user.getId();

		if (codigo == null || codigo == 0) {
			this.userDAO.salvar(user);	
		} else {
			this.userDAO.atualizar(user);
		}
		
	}
	
	public void excluir(User user) {
		this.userDAO.excluir(user);
	}
	
	public List<User> listar() {
		return this.userDAO.listar();
	}
	
	/**
	 * VERIFICANDO SE USUÁRIO EXISTE AO SE LOGAR
	 */
	/*
	public User isUsuarioReadyToLogin(String email, String password) {
		
		try {
			
			email = email.toLowerCase().trim();
			logger.info("Verificando login do usuário" + email);
			
			NamedParams dao = new NamedParams();
			List retorno = dao.findByNamedQuery( User.FIND_BY_EMAIL_SENHA, new NamedParams("email", email .trim(), "password", convertStringToMd5(password)));
			
			if (retorno.size() == 1) {
				User userFound = (User) retorno.get(0);
				return userFound;
			}
		
			return null;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BOException(e.getMessage());
		}
		
		
	}*/
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<? extends AbstractEntity> findByNamedQuery(String namedQuery)
			throws DAOException {
		try {
			logger.info((new StringBuilder("Procurando pela namedQuery "))
					.append(namedQuery).append(" sem nenhum parametro")
					.toString());
			Query query = entityManager.createNamedQuery(namedQuery);
			List<? extends AbstractEntity> returnList = (List<? extends AbstractEntity>) query
					.getResultList();
			logger.info("Objetos Encontrados: " + returnList.size());
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByNamedQuery sem parâmetros. MSG ORIGINAL: "
					+ e.getMessage());
			throw new DAOException(
					"Ocorreu um erro ao executar o findByNamedQuery sem parâmetros");
		}
	}

	
	private String convertStringToMd5(String valor) { 
			MessageDigest mDigest;
			
			try {
				//Instanciando HASH MD5
				mDigest = MessageDigest.getInstance("MD5");
				//Convert a String valor para um array de bytes em MD5
				byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
				//Convertendo os bytes para hexadecimal, assim podemos salvar no banco para posterior comparação se senhas
				StringBuffer sb = new StringBuffer();
					for (byte b : valorMD5) {
						sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
						}
						return sb.toString();
					
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null; 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}

	}
	
	
	/**
	 * MÉTODO GERADOR DE SENHA
	 * @param email 
	 * @param login 
	 */
	
	public String gerarNovaSenha() {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
				"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		String senha = "";
		for (int x = 0; x < 10; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		return senha;
	}
	

	/**
	 * ENVIA EMAIL PÓS CADASTRAMENTO DE USUÁRIO
	 */

	public void enviarEmailPosCadastramento(User user) throws BOException {
		
		String titulo = MensagemUtil.getMensagem("email_titulo");
		String mensagem = MensagemUtil.getMensagem("email_mensagem", user.getNome(), user.getUsername(), user.getPassword());
		
		try {
			EmailUtil emailutil = new EmailUtil();
			emailutil.enviarEmail(null, user.getEmail(), titulo, mensagem);
			
		} catch (UtilException e) {
			throw new BOException(e);
		}
		
	}
	
	public void excluirSelecionados() {

		for (User user : lista) {
			if (user.getCheckboxSelecao()) {
				getRoleDAO().excluir(user.getId());
			}
		}
		getRoleDAO().todos("username");

	}
	
	public void carregarPerfis() {

		listaPerfis = new ArrayList<SelectItem>();
		List<Role> list = getRoleDAO().todos("description");
			if (list != null && !list.isEmpty()) {
				for (Role perfil : list) {
					listaPerfis.add(new SelectItem(perfil, perfil
							.getDescription()));
				}
			}
	}
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public List<User> getLista() {
		return lista;
	}

	public void setLista(List<User> lista) {
		this.lista = lista;
	}

	public List<SelectItem> getListaPerfis() {
		return listaPerfis;
	}

	public void setListaPerfis(List<SelectItem> listaPerfis) {
		this.listaPerfis = listaPerfis;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
