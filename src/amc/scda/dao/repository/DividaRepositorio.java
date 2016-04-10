package amc.scda.dao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import amc.scda.dao.DividaDAO;
import amc.scda.entity.Divida;

public class DividaRepositorio implements DividaDAO {
	
	private Session session;
	
	protected static EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("MyPU");
	
	protected static EntityManager entityManager = fabrica.createEntityManager();

	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> listaTodasDividas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> dividasNaoPagas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='NAO_PAGA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> dividasEmRecurso() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='EM_RECURSO' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> dividasLiquidadas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='LIQUIDADA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> dividasExecutadas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='EXECUTADA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divida> dividasPrescritas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='PRESCRITA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}

	@Override
	public List<Divida> buscaPorStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Divida> buspaPorId() {
		// TODO Auto-generated method stub
		return null;
	}

}
