package divida.ativa.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import divida.ativa.model.Usuario;
import divida.ativa.repository.Usuarios;
import divida.ativa.util.exception.BOException;

public class UsuarioService {

	private Usuarios usuarios;

	private List<Usuario> listaUsuarios;

	public UsuarioService() {
		//this.usuarios = DAOFactory.criarUsuarioDAO();
	}

	public void salvar(Usuario user) {

		Integer codigo = user.getId();

		if (codigo == null || codigo == 0) {
			this.usuarios.salvar(user);
		} else {
			this.usuarios.atualizar(user);
		}

	}

	public void excluir(Usuario usuario) {
		this.usuarios.remover(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarios.todos();
	}

	/**
	 * VERIFICANDO SE USUÁRIO EXISTE AO SE LOGAR
	 */
	/*
	 * public User isUsuarioReadyToLogin(String email, String password) {
	 * 
	 * try {
	 * 
	 * email = email.toLowerCase().trim(); logger.info(
	 * "Verificando login do usu?rio" + email);
	 * 
	 * NamedParams dao = new NamedParams(); List retorno = dao.findByNamedQuery(
	 * User.FIND_BY_EMAIL_SENHA, new NamedParams("email", email .trim(),
	 * "password", convertStringToMd5(password)));
	 * 
	 * if (retorno.size() == 1) { User userFound = (User) retorno.get(0); return
	 * userFound; }
	 * 
	 * return null;
	 * 
	 * } catch (DAOException e) { e.printStackTrace(); throw new
	 * BOException(e.getMessage()); }
	 * 
	 * 
	 * }
	 */

	@SuppressWarnings("unused")
	private String convertStringToMd5(String valor) {
		MessageDigest mDigest;

		try {
			// Instanciando HASH MD5
			mDigest = MessageDigest.getInstance("MD5");
			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
			// Convertendo os bytes para hexadecimal, assim podemos salvar no
			// banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
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
	 * M?TODO GERADOR DE SENHA
	 * 
	 * @param email
	 * @param login
	 */

	public String gerarNovaSenha() {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		String senha = "";
		for (int x = 0; x < 10; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		return senha;
	}

	/**
	 * ENVIA EMAIL P?S CADASTRAMENTO DE USUÁRIO
	 */

	public void enviarEmailPosCadastro(Usuario usuario) throws BOException {

		

	}

	

}
