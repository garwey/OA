package oa.service;

import java.util.List;

import oa.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	/**
	 * ��ѯ���������б�
	 * 
	 * @return
	 */
	List<Department> findTopList();

	/**
	 * ��ѯ�Ӳ����б�
	 * 
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(Long parentId);
}
