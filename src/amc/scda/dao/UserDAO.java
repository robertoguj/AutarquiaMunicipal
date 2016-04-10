package amc.scda.dao;

import java.util.List;

import amc.scda.entity.User;

public interface UserDAO {

	public void salvar(User user);

	public void atualizar(User user);

	public void excluir(User user);

	public User carregar(Integer id);
	
	public List<User> listar();

	public User getBuscaPorId(Integer id);

	public User login(String username, String password);
	
}