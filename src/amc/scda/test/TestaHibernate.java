package amc.scda.test;

import amc.scda.util.HibernateUtil;

public class TestaHibernate {
	
	public static void main(String[] agrs) {
		try {
			HibernateUtil.getSessionFactory();
			System.out.println("Teste realizado com �xito! ");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao abrir sess�o ! " + e.getMessage());
		}
	}

}
