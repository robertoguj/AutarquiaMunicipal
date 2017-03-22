package scda.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import scda.model.enumeration.TiposAmbientesAplicacao;

public final class ConfigApp {

	public static final int NUM_ROWS = 20;
	
	public static final String PAGINA_LOGIN = "/login.xhtml";
	public static final String PAGINA_INDEX = "/index.xhtml";
	public static final String PAGINA_EXIBIR_PERFIL = "ExibirPerfis.xhtml";
	public static final String PAGINA_EXIBIR_USUARIO = "DashboardUsuarios.xhtml";
	    
    public static final String NOME_SISTEMA = "SISTEMA DE CONTROLE DE DÍVIDAS ATIVAS";
	public static final String MSG_SUCESSO = "Operação efetuada com sucesso.";
	public static final String MSG_ERRO = "Erro na operação, contacte o administrador do sistema.";
	public static final String MSG_NENHUM_REGISTRO = "Nenhum Registro foi localizado.";
	public static final String SLG_SISTEMA = "SCDA";

    public static final String MENU_CADASTRO = "Cadastro";
    public static final String MENU_HOME = "Home";
    public static final String MENU_USUARIO = "Usuario";
    public static final String MENU_PERFIL = "Perfil";
    public static final String MENU_ENCERRARSESSAO = "Encerrar Sessão";
    public static final String MENU_SAIR = "Sair";

    public static final String URL_MENU_HOME = "/index?faces-redirect=true";
    public static final String URL_MENU_USUARIO = "/restrito/administrador/DashboardUsuarios?faces-redirect=true";
    public static final String URL_MENU_PERFIL = "/restrito/administrador/ExibirPerfis?faces-redirect=true";

    public static final String ACAO_MENU_ENCERRARSESSAO = "#{authenticator.logout}";

	public static final String PAGINATOR_TEMPLATE = "{FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown} {CurrentPageReport}";

	public static final String ROWS_PER_PAGE_TEMPLATE = "5,10,15,20";

	public static final String CURRENT_PAGE_REPORT_TEMPLATE = "Total: {totalRecords} ({startRecord} Até {endRecord})";

	public static final String MODULO_CADASTROS = "cadastros";

	public static final String REPOSITORIO_BASE = "C:/usr/repositorioAlvarafacil";

	public static final String SEPARADOR = System.getProperty("file.separator");

	public static final String ARQUIVO_ATIVAR_LOG = "C:\\Users\\GABPREF\\Temp\\ativarLog.init";

	public static boolean LOG_ATIVO = false; // pode ser ativado se o arquivo
												// ARQUIVO_ATIVAR_LOG existir

	public static final Integer CODIGO_APLICACAO_ENVIO_EMAIL = 3;

	//public static final String URL_SERVICO_CONSULTA_TERRITORIAL = "http://172.17.0.185/autonomas/ws";
	public static final String URL_SERVICO_CONSULTA_TERRITORIAL = "http://sit.sefin.fortaleza.ce.gov.br/autonomas/ws";
	

	public static final String URL_SERVICO_CONSULTA_VIABILIDADE = "https://189.90.174.11/empreendimento/service/ViabilidadePrefeituraWS";
	public static final String URL_SERVICO_EMPREENDIMENTO_PREFEITURA = "https://189.90.174.11/empreendimento/service/EmpreendimentoPrefeituraWS";

	public static final String URL_SERVICO_GERADOR_DAM = "http://grpforhomo.sefin.fortaleza.ce.gov.br/grpforservicos/DamTaxasWs/DamTaxasWs?wsdl";
	public static final String URL_SERVICO_CONSULTAR_DAM = "http://grpforhomo.sefin.fortaleza.ce.gov.br/grpforservicos/ConsultaDamEmitidoWs/ConsultaDamEmitidoWs?wsdl";

	public static String userJobID = "alvarafacilschedule";
	public static String userJobPASSWORD = "" + (new Random().nextInt(99999999));

	public static final String CHAVE_CRIPTOGRAFIA = "000102030405060708090A0B0C0D0E0F";

	public static final String URL_APP_PRODUCAO = "http://portal.amc.fortaleza.ce.gov.br";
	public static final String URL_APP_HOMOLOGACAO = "http://hom.portal.amc.fortaleza.ce.gov.br";
	public static final String URL_APP_DESENVOLVIMENTO = "http://localhost:8080/scda";

	public static TiposAmbientesAplicacao TIPO_AMBIENTE_APLICACAO = TiposAmbientesAplicacao.HOMOLOGACAO;

	public static String getUrlAPP() {
		switch (TIPO_AMBIENTE_APLICACAO) {
		case PRODUCAO:
			return URL_APP_PRODUCAO;
		case HOMOLOGACAO:
			return URL_APP_HOMOLOGACAO;
		case DESENVOLVIMENTO:
			return URL_APP_DESENVOLVIMENTO;
		case TREINAMENTO:
			return URL_APP_HOMOLOGACAO;
		default:
			return URL_APP_PRODUCAO;
		}
	}
	
	//Crio uma instancia da classe properties
    private static Properties prop = new Properties();
     
    //Crio um método estático que pode ser acessado por outras classes da aplicação sem a necessidade de instanciar
    public static Properties propertiesLoader() {
         
        //Informo o caminho onde se encontra meu arquivo properties de forma dinâmica
        //Poderia fazer isso de forma estática passando o diretório completo mas obviamente isso não é muito interessante.
    	String dir = "c://servicos";
        String atualDir = "servicos.properties";
        try {   //Tento recuperar as informaÃ§Ãµes do arquivo de propriedades       
            //Crio uma instância de File passando o meu arquivo .properties via construtor
            File file = new File(dir, atualDir); 
            //Agora crio uma instância de FileInputStream passando via construtor o objeto file instanciado acima
            FileInputStream fileInputStream = new FileInputStream(file);
            //Leio o fileInputStream recuperando assim o mapa contendo chaves e valores
            prop.load(fileInputStream);
          //Fecho o fileInputStream
            fileInputStream.close();
           
        } catch (Exception e) {
            //Trato possíveis exceções
        	e.printStackTrace();
        }
        return prop;
        //Retorno um objeto prop com o mapa correspondente ao meu arquivo properties
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
    
}
