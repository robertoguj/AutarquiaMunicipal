package divida.ativa.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import divida.ativa.model.Divida;
import divida.ativa.model.enu.StatusDivida;

public class Dividas extends DaoGenerico<Divida, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Divida> listarDividas() {
		Query query = entityManager.createQuery("SELECT d FROM Divida d");
		List<Divida> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Divida> encontrarDividasNaoPagas() {
		Query query = entityManager.createQuery("from Divida where status_atual=" + StatusDivida.NAO_PAGA);
		List<Divida> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Divida> encontrarDividasEmRecurso() {
		Query query = entityManager.createQuery("from Divida where status_atual=" + StatusDivida.EM_RECURSO);
		List<Divida> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Divida> encontrarDividasLiquidadas() {
		Query query = entityManager.createQuery("from Divida where status_atual=" + StatusDivida.LIQUIDADA);
		List<Divida> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Divida> encontrarDividasExecutadas() {
		Query query = entityManager.createQuery("from Divida where status_atual=" + StatusDivida.EXECUTADA);
		List<Divida> lista = query.getResultList();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Divida> encontrarDividasPrescritas() {
		Query query = entityManager.createQuery("from Divida where status_atual=" + StatusDivida.PRE_INSCRITA);
		List<Divida> lista = query.getResultList();

		return lista;
	}

}
