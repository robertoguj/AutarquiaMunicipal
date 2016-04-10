package amc.scda.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import amc.scda.entity.AbstractEntity;
import amc.scda.util.exception.DAOException;

public class NamedParams implements Serializable, Map<String, Object> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(NamedParams.class);

	private EntityManager entityManager;

	
	public NamedParams(String string, String trim, String string2,
			String convertStringToMd5) {
		// TODO Auto-generated constructor stub
	}



	/**
	 * OP��O 1: findByNamedQuery com par�metros
	 * 
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<? extends AbstractEntity> findByNamedQuery(String namedQuery,
			Map<String, Object> namedParams) throws DAOException {
		try {
			logger.info("Procurando pela namedQuery " + namedQuery + " com "
					+ namedParams.size() + " parametros");
			Query query = entityManager.createNamedQuery(namedQuery);
			if (namedParams != null) {
				Entry<String, Object> mapEntry;
				for (Iterator it = namedParams.entrySet().iterator(); it
						.hasNext(); query.setParameter(
						(String) mapEntry.getKey(), mapEntry.getValue())) {
					mapEntry = (Entry<String, Object>) it.next();
					logger.info("Param: " + mapEntry.getKey() + ", Value: "
							+ mapEntry.getValue());
				}
			}
			List<? extends AbstractEntity> returnList = (List<? extends AbstractEntity>) query
					.getResultList();
			logger.info("Objetos Encontrados: " + returnList.size());
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByNamedQuery com par�metros. MSG ORIGINAL: "
					+ e.getMessage());
			throw new DAOException(
					"Ocorreu um erro ao executar o findByNamedQuery com par�metros");
		}
	}

	
	
	/**
	 * OP��O 2: findByNamedQuery com par�metros e limitando a quantidade m�xima de resultados que deve ser retornado 
	 *
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<? extends AbstractEntity> findByNamedQuery(String namedQuery,
			Map<String, Object> namedParams, int maxResults) throws DAOException {
		try {
			logger.info("Procurando pela namedQuery " + namedQuery + " com "
					+ namedParams.size() + " parametros");
			Query query = entityManager.createNamedQuery(namedQuery);
			query.setMaxResults(maxResults);
			if (namedParams != null) {
				Entry<String, Object> mapEntry;
				for (Iterator it = namedParams.entrySet().iterator(); it
						.hasNext(); query.setParameter(
						(String) mapEntry.getKey(), mapEntry.getValue())) {
					mapEntry = (Entry<String, Object>) it.next();
					logger.info("Param: " + mapEntry.getKey() + ", Value: "
							+ mapEntry.getValue());
				}
			}
			List<? extends AbstractEntity> returnList = (List<? extends AbstractEntity>) query
					.getResultList();
			logger.info("Objetos Encontrados: " + returnList.size());
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByNamedQuery com par�metros. MSG ORIGINAL: "
					+ e.getMessage());
			throw new DAOException(
					"Ocorreu um erro ao executar o findByNamedQuery com par�metros");
		}
	}

	
	
	/**
	 * OP��O 3: findByNamedQuery sem par�metros e n�o limita��o a quantidade 
	 *
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<? extends AbstractEntity> findByNamedQuery(String namedQuery) throws DAOException {
		try {
			logger.info((new StringBuilder("Procurando pela namedQuery "))
					.append(namedQuery).append(" sem nenhum parametro")
					.toString());
			Query query = entityManager.createNamedQuery(namedQuery);
			List<? extends AbstractEntity> returnList = (List<? extends AbstractEntity>) query
					.getResultList();
			logger.info("Objetos Encontrados: " + returnList.size());
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByNamedQuery sem par�metros. MSG ORIGINAL: "
					+ e.getMessage());
			throw new DAOException(
					"Ocorreu um erro ao executar o findByNamedQuery sem par�metros");
		}
	}

	
	
	/**
	 * OP��O 4: findByNamedQuery sem par�metros, mas com limita��o de quantidade de resultados 
	 *
	 */
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<? extends AbstractEntity> findByNamedQuery(String namedQuery,
			int maxResults) throws DAOException {
		try {
			logger.info((new StringBuilder("Procurando pela namedQuery "))
					.append(namedQuery).append(" sem nenhum parametro")
					.toString());
			Query query = entityManager.createNamedQuery(namedQuery);
			query.setMaxResults(maxResults);
			List<? extends AbstractEntity> returnList = (List<? extends AbstractEntity>) query
					.getResultList();
			logger.info("Objetos Encontrados: " + returnList.size());
			return returnList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByNamedQuery sem par�metros. MSG ORIGINAL: "
					+ e.getMessage());
			throw new DAOException(
					"Ocorreu um erro ao executar o findByNamedQuery sem par�metros");
		}
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
