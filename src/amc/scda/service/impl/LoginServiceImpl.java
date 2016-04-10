package amc.scda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amc.scda.dao.UserDAO;
import amc.scda.entity.User;
import amc.scda.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDAO dao;

	@Override
	public User login(String username, String password)
			throws IllegalArgumentException {
		if (isEmptyOrNull(username) || isEmptyOrNull(password)) {
			throw new IllegalArgumentException(
					"Aten��o, usu�rio ou senha vazios!");
		}
		User u = dao.login(username, password);
		
		if (u == null) {
			throw new IllegalArgumentException(
					"Nome de usu�rio ou senha inv�lidos!");
		}
		return u;
	}

	private boolean isEmptyOrNull(String s) {
		return s == null || s.equals("");
	}
}
