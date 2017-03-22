package scda.security;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import scda.model.Usuario;

@Controller
@Scope("request")
public class Authenticator implements AuthenticationProvider {
	@Autowired
	private LoginService service;

	@Autowired
	private UserSession session;

	private String username;
	private String password;

	public String login() {
		try {
			Usuario usuario = service.login(username, password);
			loginSpringSecurity(usuario);
			session.setUsuario(usuario);
			return "successfulPage";
		} catch (IllegalArgumentException ex) {
			message(ex.getMessage());
		}
		return "";
	}

	private void loginSpringSecurity(Usuario usuario) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				usuario.getUsername(), null, usuario.getPerfis());
		token.setDetails(usuario);

		SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		session.setUsuario(null);
		return "index";
	}
	
	/*
	 * http://stackoverflow.com/questions/24145253/how-get-current-logged-in-username-in-spring-security-with-jsf
	 * Recupera o usu�rio logado na sess�o
	 */
	
	public String loggedName() throws IOException,ServletException{
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    if (principal instanceof UserDetails) {
	      username = ((UserDetails)principal).getUsername();
	    } else {
	       username = principal.toString();
	    }
	    return username;
	}

	private void message(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(message));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
