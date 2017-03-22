package scda.security;

import scda.model.Usuario;

public interface LoginService {
	Usuario login(String username, String password) throws IllegalArgumentException;
}
