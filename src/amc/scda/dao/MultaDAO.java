package amc.scda.dao;

import java.util.List;

import javax.persistence.Query;

import amc.scda.dao.repository.RepositorioJPA;
import amc.scda.entity.Multa;

public class MultaDAO extends RepositorioJPA<Multa, Integer> {
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasNaoPagas() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='NAO_PAGA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasProntasParaNoticacao() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='PRONTA_NOTIFICACAO' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasNotificadas() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='NOTIFICADA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasEmRecurso() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='EM_RECURSO' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasLiquidadas() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='LIQUIDADA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasExecutadas() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='INSCRITA_EM_DIVIDA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasPrescritas() {
		
		Query query = entityManager.createQuery("SELECT m FROM Multa m WHERE status='PRESCRITA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}

}
