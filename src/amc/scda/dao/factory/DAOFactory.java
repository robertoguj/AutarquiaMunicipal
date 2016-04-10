package amc.scda.dao.factory;

import amc.scda.dao.DividaDAO;
import amc.scda.dao.UserDAO;
import amc.scda.dao.repository.DividaRepositorio;
import amc.scda.dao.repository.UserRepositorio;
import amc.scda.util.HibernateUtil;

public class DAOFactory {
	
	public static UserDAO criarUsuarioDAO() {
		UserRepositorio userDAO = new UserRepositorio();
		userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
	
	public static DividaDAO criarDividaDAO() {
		DividaRepositorio dividaDAO = new DividaRepositorio();
		dividaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());;
		return dividaDAO;
	}

}
