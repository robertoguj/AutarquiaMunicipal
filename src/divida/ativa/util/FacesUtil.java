package divida.ativa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import divida.ativa.model.Usuario;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FacesUtil {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void SetVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void register(Usuario user) {
		confirmarEnvio(user);
	}

	private void confirmarEnvio(final Usuario usuario) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(usuario.getEmail());
				message.setSubject("Confirmação de cadastro");
				message.setFrom("MyImage.com");
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("profile", usuario);
				model.put("context", getContextPath());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/registration-confirmation.vm", "UTF-8", model);
				message.setText(text, true);
			}
		};

		this.mailSender.send(preparator);
	}
	
	
	public static String getContextPath() {
		 
        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url.substring(0, url.length() - req.getRequestURI().length())
                + req.getContextPath() + "/";
    }
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorio(String nomeRelatorio, HashMap paramRel,
			List listaRel) {

		String retorno = null;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context
					.getExternalContext().getResponse();
			ServletContext sc = (ServletContext) context.getExternalContext()
					.getContext();
			String relPath = sc.getRealPath("/");
			String imagemLogo = relPath + "recursos/imagem/logo_mmo.jpg";
			paramRel.put("imagemLogo", imagemLogo);
			paramRel.put("nmSistema", ConfigApp.NOME_SISTEMA);
			paramRel.put("REPORT_LOCALE", new Locale("pt", "BR"));

			JasperPrint print = null;
			if (listaRel != null) {
				JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(
						listaRel);
				print = JasperFillManager.fillReport(relPath + "relatorios/"
						+ nomeRelatorio + ".jasper", paramRel, rel);
			} else {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/sgc";
				String user = "postgres";
				String pass = "admin";
				Connection connection = DriverManager.getConnection(url, user,
						pass);
				print = JasperFillManager.fillReport(relPath + "relatorios/"
						+ nomeRelatorio + ".jasper", paramRel, connection);
			}

			// Exibe o relat?rio no formato pdf

			byte[] bytes = JasperExportManager.exportReportToPdf(print);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return retorno;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void gerarRelatorioSub(String nomeRelatorio,
			HashMap paramRel, List listaRel, List listaRelSub,
			String subNomeRelatorio) {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		ServletContext sc = (ServletContext) context.getExternalContext()
				.getContext();
		String relPath = sc.getRealPath("/");
		String imagemLogo = relPath + "recursos/imagem/logo_mmo.jpg";
		paramRel.put("imagemLogo", imagemLogo);
		paramRel.put("nmSistema", ConfigApp.NOME_SISTEMA);
		paramRel.put("REPORT_LOCALE", new Locale("pt", "BR"));
		subNomeRelatorio = relPath + "relatorios/" + subNomeRelatorio
				+ ".jasper";
		paramRel.put("subNomeRelatorio", subNomeRelatorio);

		try {

			JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(
					listaRel);
			JRBeanCollectionDataSource relSub = new JRBeanCollectionDataSource(
					listaRelSub);
			paramRel.put("relSub", relSub);
			JasperPrint print = JasperFillManager.fillReport(relPath
					+ "relatorios/" + nomeRelatorio + ".jasper", paramRel, rel);

			// Exibe o relat?rio no formato pdf

			byte[] bytes = JasperExportManager.exportReportToPdf(print);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	
}
