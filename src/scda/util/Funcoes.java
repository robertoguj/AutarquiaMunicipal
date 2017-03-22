package scda.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Funcoes {

	
	public static Date getDataAtual() {
		
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
		formatacao.format(data);
		
		return data;
	}
	
	public Date formatatarDataHora(String data) {
		Calendar calData = Calendar.getInstance();
		int ano, mes, dia;
		ano = mes = dia = 0;
		if (!data.equalsIgnoreCase("")) {
			dia = Integer.parseInt(data.substring(0, 2));
			mes = Integer.parseInt(data.substring(2, 4));
			ano = Integer.parseInt(data.substring(4, 8));
		}
		calData.set(Calendar.YEAR, ano);
		calData.set(Calendar.MONTH, mes - 1);
		calData.set(Calendar.DAY_OF_MONTH, dia);
		return calData.getTime();
	}

	public static String getMes(Date data) {
		String retorno = new String();
		int mes = Integer.parseInt(Funcoes.getDataMM(data));
		switch (mes) {
		case 1:
			retorno = "Janeiro";
			break;
		case 2:
			retorno = "Fevereiro";
			break;
		case 3:
			retorno = "Março";
			break;
		case 4:
			retorno = "Abril";
			break;
		case 5:
			retorno = "Maio";
			break;
		case 6:
			retorno = "Junho";
			break;
		case 7:
			retorno = "Julho";
			break;
		case 8:
			retorno = "Agosto";
			break;
		case 9:
			retorno = "Setembro";
			break;
		case 10:
			retorno = "Outubro";
			break;
		case 11:
			retorno = "Novembro";
			break;
		case 12:
			retorno = "Dezembro";
			break;
		}
		return retorno;
	}

	public static String getDiaDaSemana(Date data) {
		String retorno = null;
		Calendar dataInicio = Calendar.getInstance();
		int dia = 0;
		dataInicio.setTime(data);
		dia = dataInicio.get(Calendar.DAY_OF_WEEK);
		switch (dia) {
		case 1:
			retorno = "Domingo";
			break;
		case 2:
			retorno = "Segunda-Feira";
			break;
		case 3:
			retorno = "Terça-Feira";
			break;
		case 4:
			retorno = "Quarta-Feira";
			break;
		case 5:
			retorno = "Quinta-Feira";
			break;
		case 6:
			retorno = "Sexta-Feira";
			break;
		case 7:
			retorno = "Sabado";
			break;
		}

		return retorno;
	}

	public static String getDatayyyy(java.util.Date data) {
		SimpleDateFormat dataSimples = new SimpleDateFormat("yyyy");
		return data != null ? dataSimples.format(data) : "";
	}

	public static String getDataMM(java.util.Date data) {
		SimpleDateFormat dataSimples = new SimpleDateFormat("MM");
		return data != null ? dataSimples.format(data) : "";
	}

	public static String getDatadd(java.util.Date data) {
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd");
		return data != null ? dataSimples.format(data) : "";
	}

	public static String dataSimplesParaString(java.util.Date data) {
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
		return data != null ? dataSimples.format(data) : "";
	}

	public static String getDatayyyymmdd(java.util.Date data) {
		SimpleDateFormat dataSimples = new SimpleDateFormat("yyyyMMdd");
		return data != null ? dataSimples.format(data) : "";
	}

	public static String moeda(float v) {
		DecimalFormat moeda = new DecimalFormat("#,##0.00");
		return moeda.format(v);
	}

	public static String moeda(double v) {
		DecimalFormat moeda = new DecimalFormat("#,##0.00");
		return moeda.format(v);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorio(String nomeRelatorio, HashMap paramRel,
			List listaRel) {
		String retorno = null;
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
		try {
			JasperPrint print = null;
			if (listaRel != null) {
				JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(
						listaRel);
				print = JasperFillManager.fillReport(relPath + "relatorios/"
						+ nomeRelatorio + ".jasper", paramRel, rel);
			} else {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/scda";
				String user = "postgres";
				String pass = "admin";
				Connection connection = DriverManager.getConnection(url, user,
						pass);
				print = JasperFillManager.fillReport(relPath + "relatorios/"
						+ nomeRelatorio + ".jasper", paramRel, connection);

			}
			byte[] bytes = JasperExportManager.exportReportToPdf(print);
			// Exibe o relatório no formato PDF
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			// String texterro = e.toString();
			retorno = e.toString();
			System.out.println(e.toString());
		}
		return retorno;
	}

	public static boolean hasValue(String str) {
		if (str != null && !str.trim().equals(""))
			return true;

		return false;
	}

	public static boolean hasValue(Object obj) {
		if (obj != null)
			return true;

		return false;
	}

	public long calcularDiasCorridos(Date inicio, Date fim) {
		Calendar dataInicio = Calendar.getInstance();
		Calendar dataFim = Calendar.getInstance();
		long horas = 0;
		// dataInicio.set(anoI, mesI, diaI, horaI, minI);
		// dataFim.set(anoF, mesF, diaF, horaF, minF);
		dataInicio.setTime(inicio);
		dataFim.setTime(fim);
		horas = dataFim.getTimeInMillis() - dataInicio.getTimeInMillis();
		horas = horas / 1000 / 60; // milisegundos para segundos e segundos para
		// minutos
		horas = horas / 60; // minuto para hora
		long dias = horas / 24;
		dias = Math.round(dias);

		return dias;
	}
	
	
	public static String preencheAEsquerda(String valor, char caracter,
			int tamanho) {
		return String.format(
				"%" + String.valueOf(caracter) + String.valueOf(tamanho) + "d",
				valor);
	}

	
	public static String formataDataEmString(Date data) {
		SimpleDateFormat out;
		try {
			out = new SimpleDateFormat("dd/MM/yyyy");
			return out.format(data);
		} catch (Exception e) {
			return "Erro ao formatar a Data";
		}
	}

	
	public static String formataHoraEmString(Date data) {
		SimpleDateFormat out;
		try {
			out = new SimpleDateFormat("HH:mm:ss");
			return out.format(data);
		} catch (Exception e) {
			return "Erro ao formatar a Hora";
		}
	}


	public static Date formataStringEmData(String data) {
		if (data == null || data.equals("")) {
			return null;
		}
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (java.util.Date) formatter.parse(data);
		} catch (Exception e) {
		}
		return date;
	}

	
	public static String concatenaAspas(String valor) {
		return "";
	}

	
	public static String retornaSistemaOperacional() {
		return System.getProperties().get("os.name").toString();
	}

	
	public static String removeCaracteresEspeciais(String texto) {
		/* Remove alguns caracteres especiais da string */
		texto = texto.replaceAll("\\.?", "");
		texto = texto.replaceAll("-?", "");
		texto = texto.replaceAll("\\(?", "");
		texto = texto.replaceAll("\\)?", "");
		texto = texto.replaceAll("\\_?", "");
		texto = texto.replaceAll(" ", "");
		return texto;
	}

	
	public static boolean ehAlfa(String texto) {
		return texto.matches("[a-zA-Z]*");
	}

	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static ArrayList<String> listaCamposComValores(Class classe,
			ArrayList listaParametro) {
		ArrayList listaCampos = new ArrayList();
		try {
			Field[] campos = classe.getDeclaredFields();
			/* Method[] metodos = classe.getDeclaredMethods(); */
			for (Field f : campos) {
				/*
				 * for (Method m : metodos) { m.setAccessible(true); }
				 */
			}
		} catch (Exception ex) {
			System.out.println("Erro ocorrido: " + ex);
		}
		return listaCampos;
	}

	
	// VALIDA CPF

	public static boolean validaCPF(String strCpf) {
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount))
					.intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}

		// Primeiro resto da divisão por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
		if (resto < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		d2 += 2 * digito1;

		// Segundo resto da divisão por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
		if (resto < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Digito verificador do CPF que está sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2,
				strCpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
		return nDigVerific.equals(nDigResult);
	}

	
}
