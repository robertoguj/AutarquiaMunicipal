package amc.scda.dao.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;


public class RepositorioJPA<T, ID extends Serializable> {


	protected static EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("MyPU");
	
	protected static EntityManager entityManager = fabrica.createEntityManager();

	private final Class<T> classePersistence;

	@SuppressWarnings("unchecked")
	public RepositorioJPA() {
		this.classePersistence = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T salvar(T object) {
		EntityManager entityManager = fabrica.createEntityManager();
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.persist(object);
		transacao.commit();
		entityManager.close();
		return null;
	}

	public T atualizar(T object) {
		EntityManager entityManager = fabrica.createEntityManager();
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.merge(object);
		transacao.commit();
		entityManager.close();
		return null;
	}
	
	public void excluir(ID id) {
		EntityManager entityManager = fabrica.createEntityManager();
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		T object = entityManager.find(getClassePersistence(), id);
		entityManager.remove(object);
		transacao.commit();
		entityManager.close();
	}

	public T buscaPorId(ID id) {
		EntityManager entityManager = fabrica.createEntityManager();
		return entityManager.find(getClassePersistence(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> todos(String ordem) {
		EntityManager entityManager = fabrica.createEntityManager();
		StringBuffer queryS = new StringBuffer("SELECT obj FROM "
				+ classePersistence.getSimpleName() + " obj ");
		if (ordem != null) {
			queryS.append(" order by " + ordem);
		}
		Query query = entityManager.createQuery(queryS.toString());
		return query.getResultList();
	}
	
	// CRIANDO UMA CONSULTA COM CRITERIA

	protected final Criteria criaCriteria() {
		EntityManager entityManager = fabrica.createEntityManager();
		Session session = (Session) entityManager.getDelegate();
		return session.createCriteria(getClassePersistence());
	}

	public Class<T> getClassePersistence() {
		return classePersistence;
	}
	
	
	
}
