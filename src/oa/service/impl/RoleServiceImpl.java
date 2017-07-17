package oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.base.DaoSupportImpl;
import oa.domain.Role;
import oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

	// @Resource
	// private RoleDao roleDao;
	//
	// public Role getById(Long id) {
	// return roleDao.getById(id);
	// }
	//
	// public void delete(Long id) {
	// roleDao.delete(id);
	// }
	//
	// public void save(Role role) {
	// roleDao.save(role);
	// }
	//
	// public void update(Role role) {
	// roleDao.update(role);
	// }
	//
	// public List<Role> findAll() {
	// return roleDao.findAll();
	// }

}
