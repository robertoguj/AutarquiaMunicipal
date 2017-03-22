package divida.ativa.repository;

import java.io.Serializable;

import divida.ativa.model.Divida;

public class Dividas extends DaoGenerico<Divida, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/*
	
	@SuppressWarnings("unchecked")
	public List<Divida> listarDividas() {
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
*/

}
