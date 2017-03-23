package divida.ativa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FacesUtil {

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
