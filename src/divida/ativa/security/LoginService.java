package divida.ativa.security;

import divida.ativa.model.Usuario;

public interface LoginService {
	Usuario login(String username, String password) throws IllegalArgumentException;
}
