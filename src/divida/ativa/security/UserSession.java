package divida.ativa.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import divida.ativa.model.Usuario;

@Component
@Scope("session")
public class UserSession {
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLoggedIn() {
		return usuario != null;
	}

}
