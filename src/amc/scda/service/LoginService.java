package amc.scda.service;

import amc.scda.entity.User;

public interface LoginService {
	User login(String username, String password) throws IllegalArgumentException;
}
