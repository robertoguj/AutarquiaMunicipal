package amc.scda.dao;

import java.util.List;
import java.util.Map;

import amc.scda.entity.AbstractEntity;

public interface BasicDAO {

	public abstract List<? extends AbstractEntity> findByNamedQuery(String s,
			Map<String, Object> map);

	public abstract List<? extends AbstractEntity> findByNamedQuery(String s);

	public abstract List<? extends AbstractEntity> findByQuery(String s,
			Map<String, Object> map);

	public abstract List<? extends AbstractEntity> findByNamedQuery(String s,
			Map<String, Object> map, int maxResults);

	public abstract List<? extends AbstractEntity> findByNamedQuery(String s,
			int maxResults);

	public abstract List<? extends AbstractEntity> findByQuery(String s,
			Map<String, Object> map, int maxResults);

	public abstract AbstractEntity save(AbstractEntity abstractbean);

	public abstract AbstractEntity saveFlushAndClear(AbstractEntity abstractbean);

	public abstract void update(AbstractEntity abstractbean);

	public abstract void delete(AbstractEntity abstractbean);

	public abstract void clear();

	public abstract void flushAndClear();

	public abstract void flush();
	
	/**
	 * http://www.devmedia.com.br/jpa-e-spring-framework-criando-um-dao-generico/30131
	 */

}
