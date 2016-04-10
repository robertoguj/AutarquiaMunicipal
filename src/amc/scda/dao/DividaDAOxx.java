package amc.scda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import amc.scda.dao.repository.RepositorioJPA;
import amc.scda.entity.Divida;

public class DividaDAOxx extends RepositorioJPA<Divida, Integer> {
	
	@SuppressWarnings("unchecked")
	public List<Divida> consultaPorStatus() {
		
		StringBuffer strHql = new StringBuffer("from dividas d" + " where d.status = ?");
		
		EntityManager entityManager = fabrica.createEntityManager();
		Query query = entityManager.createQuery(strHql.toString());
		
		return (List<Divida>) query.getResultList();
	}
	
	
	/**
	 * Linguagem de Consulta dp JPA (JPQL)
	 */
	
	
	@SuppressWarnings("unchecked")
	public List<Divida> todos() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Divida> dividasPreInscritas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='PRE_INSCRITA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}
	

	public List<Divida> dividasNaoPagas() {
		TypedQuery<Divida> query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='NAO_PAGA' ", Divida.class);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Divida> dividasEmRecurso() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='EM_RECURSO' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Divida> dividasLiquidadas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='LIQUIDADA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Divida> dividasExecutadas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='EXECUTADA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Divida> dividasPrescritas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d WHERE status='PRESCRITA' ");
		List<Divida> lista = query.getResultList();
		
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Divida> consultaPorStatus(Divida divida) {
		
		Criteria criteria = criaCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.createAlias("divida.status", "status");
		criteria.addOrder(Order.asc("status."));
		
		return (List<Divida>) criteria.list();

	}
	
	public List<Divida> consultarPorProprietario() {
		
		
		return null;
	}


	

}
