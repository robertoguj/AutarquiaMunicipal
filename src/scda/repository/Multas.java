package scda.repository;

import java.io.Serializable;

import scda.model.Multa;

public class Multas extends DaoGenerico<Multa, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/*
	@SuppressWarnings("unchecked")
	public List<Multa> multasNaoPagas() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='NAO_PAGA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasProntasParaNoticacao() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='PRONTA_NOTIFICACAO' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasNotificadas() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='NOTIFICADA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasEmRecurso() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='EM_RECURSO' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasLiquidadas() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='LIQUIDADA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasExecutadas() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='INSCRITA_EM_DIVIDA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Multa> multasPrescritas() {
		
		Query query = (Query) sessao.createQuery("SELECT m FROM Multa m WHERE status='PRESCRITA' ");
		List<Multa> lista = query.getResultList();
		
		return lista;
	}
*/


}
