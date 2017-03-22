
package divida.ativa.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static void addInfoMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}

	public static void addWarnMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}

	public static void addErrorMessage(String summary) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				summary, "");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, facesMsg);
	}
	
	 public String getMessage(String key) {
			try {
				FacesContext fc = FacesContext.getCurrentInstance();
				ResourceBundle rb = ResourceBundle.getBundle("messages", fc.getViewRoot().getLocale());
				String mensagem = rb.getString(key);
				return mensagem;
				
			} catch (Exception e) {
				return "";
			}
		}

}
