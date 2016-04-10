package amc.scda.controller.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import amc.scda.util.Funcoes;

public abstract class AbstractController {
	
	protected static final Logger logger = Logger.getLogger(AbstractController.class);

	protected Integer total = 0;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

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
			ResourceBundle rb = ResourceBundle.getBundle("messages", fc
					.getViewRoot().getLocale());
			String mensagem = rb.getString(key);
			return mensagem;
		} catch (Exception e) {
			return "";
		}
	}

	public Boolean getAcesso() {
		Boolean retorno = new Boolean(true);
		return retorno;
	}

	public String getRodapePag() {
		Date datAtual = new Date();
		StringBuffer retorno = new StringBuffer(ConfigApp.SLG_SISTEMA + " - ");
		retorno.append(Funcoes.getDiaDaSemana(datAtual));
		retorno.append(" , " + Funcoes.getDatadd(datAtual) + " de ");
		retorno.append(Funcoes.getMes(datAtual) + " de ");
		retorno.append(Funcoes.getDatayyyy(datAtual) + " - ");
		retorno.append("Usuário: ");
		retorno.append("Roberto Pereira");
		retorno.append(" - Analista Desenvolvedor");
		return retorno.toString();
	}

	public String principal() {
		return "principal";
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

			// Exibe o relatório no formato pdf

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

			// Exibe o relatório no formato pdf

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
	
	public void submit() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correto", "Correto");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
