package amc.scda.dao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amc.scda.dao.UserDAO;
import amc.scda.entity.User;

@Repository
@Transactional
public class UserRepositorio implements UserDAO {
	
	private Session session;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listar() {
		return entityManager.createQuery("FROM User").getResultList();
	}

	@Override
	public void salvar(User user) {
		entityManager.persist(user);
		session.saveOrUpdate(user);
	}

	@Override
	public void atualizar(User user) {
		entityManager.persist(user);
	}

	@Override
	public void excluir(User user) {
		user = getBuscaPorId(user.getId());
		entityManager.remove(user);
	}
	
	@Override
	public User carregar(Integer id) {
		return (User) this.session.get(User.class, id);
	}

	@Override
	public User getBuscaPorId(Integer id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User login(String username, String password) {
		String query = "FROM User u where u.username = ? and u.password=?";
		Query q = entityManager.createQuery(query);
		q.setParameter(1, username);
		q.setParameter(2, password);

		List l = q.getResultList();

		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (User) l.get(0);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
		
	}

}
