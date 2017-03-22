package scda.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scda.model.Usuario;

@Repository
@Transactional
public class Usuarios extends DaoGenerico<Usuario, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("rawtypes")
	public Usuario login(String username, String password) {
		String query = "FROM Usuario u where u.username = ? and u.password=?";
		Query q = entityManager.createQuery(query);
		q.setParameter(1, username);
		q.setParameter(2, password);

		List l = q.getResultList();

		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (Usuario) l.get(0);
	}

}
