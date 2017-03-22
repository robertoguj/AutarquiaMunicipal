package scda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scda.model.Usuario;
import scda.repository.Usuarios;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private Usuarios usuarios;

	@Override
	public Usuario login(String username, String password)
			throws IllegalArgumentException {
		if (isEmptyOrNull(username) || isEmptyOrNull(password)) {
			throw new IllegalArgumentException("Atenção, usuário ou senha vazios!");
		}
		Usuario u = usuarios.login(username, password);
		
		if (u == null) {
			throw new IllegalArgumentException("Nome de usuário ou senha inválidos!");
		}
		return u;
	}

	private boolean isEmptyOrNull(String s) {
		return s == null || s.equals("");
	}
}
