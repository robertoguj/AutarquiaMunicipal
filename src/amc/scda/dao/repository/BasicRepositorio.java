package amc.scda.dao.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import amc.scda.dao.BasicDAO;
import amc.scda.entity.AbstractEntity;

@Repository(value = "basicDAO")
public class BasicRepositorio implements BasicDAO, Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(type = javax.persistence.PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;
	
	
	protected static Logger logger = Logger.getLogger(BasicRepositorio.class);
	
	@Override
	public List<? extends AbstractEntity> findByNamedQuery(String s,
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AbstractEntity> findByNamedQuery(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AbstractEntity> findByQuery(String s,
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AbstractEntity> findByNamedQuery(String s,
			Map<String, Object> map, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AbstractEntity> findByNamedQuery(String s,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends AbstractEntity> findByQuery(String s,
			Map<String, Object> map, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractEntity save(AbstractEntity abstractbean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractEntity saveFlushAndClear(AbstractEntity abstractbean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AbstractEntity abstractbean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AbstractEntity abstractbean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flushAndClear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

}
