package oa.base;

import java.util.List;

public interface DaoSupport<T> {

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * ����ʵ��
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * ��id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * ��id��ѯ
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	List<T> findAll();

}
