package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.base.DaoSupportImpl;
import oa.domain.Department;
import oa.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	@Resource
	private SessionFactory sessionFactory;

	public List<Department> findTopList() {
		return sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	public List<Department> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession()
				.createQuery(//
						"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	@Override
	public void delete(Long id) {
		Department d = getById(id);
		if (d != null) {
			Long parentId = d.getParent().getId();
			Department pd = getById(id);
			getSession().delete(d);
		}
	}

}