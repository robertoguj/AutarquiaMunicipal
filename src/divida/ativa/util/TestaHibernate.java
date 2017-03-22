package divida.ativa.util;

import divida.ativa.util.HibernateUtil;

public class TestaHibernate {
	
	public static void main(String[] agrs) {
		try {
			HibernateUtil.getSessionFactory();
			System.out.println("Teste realizado com êxito! ");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao abrir sessão! " + e.getMessage());
		}
	}

}
