package amc.scda.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class RedirectorBean {
	
	public String index() {
		return "index";
	}

	public String successfulPage() {
		return "successfulPages";
	}
	
	public String usuarios() {
		return "dashboardUsuarios";
	}
	
	public String novoUsuario() {
		return "novoUsuario";
	}
	
	public String editarUsuario() {
		return "editarUsuario";
	}

	public String dividasAtivas() {
		return "dashboardDividas";
	}
	
	public String dividasLegado() {
		return "dashboardDividasLegado";
	}
	
	public String multasTramite() {
		return "dashboardMultas";
	}
	
	public String multasVencidas() {
		return "dashboardMultasVencidas";
	}
	
	public String emitirCda() {
		return "emitirCda";
	}
	
	public String emitirPeticao() {
		return "emitirPeticao";
	}
	
	public String emitirCertidao() {
		return "emitirCertidao";
	}
	
	public String validarCertidao() {
		return "validarCertidao";
	}

	public String consultarDividasLegado() {
		return "consultaDividaLegado";
	}
	
	public String consultarDividasAtivas() {
		return "consultaDividaAtiva";
	}
	
	public String consultarMultas() {
		return "consultaMultas";
	}
	
	public String historicoDividas() {
		return "historicoDividas";
	}
	
	public String emitirBoleto() {
		return "emitirBoleto";
	}
	
	public String emitirRelDividasAtivas() {
		return "relatorioDividasAtivas";
	}
	
	public String emitirRelMultas() {
		return "relatorioMultas";
	}

}
