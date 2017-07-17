package oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import oa.base.BaseAction;
import oa.domain.Role;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	/** �б� */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** ɾ�� */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** ���ҳ�� */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** ��� */
	public String add() throws Exception {
		// // ��װ��������
		// Role role = new Role();
		// role.setName(model.getName());
		// role.setDescription(model.getDescription());
		//
		// // ���浽���ݿ�
		// roleService.save(role);

		roleService.save(model);

		return "toList";
	}

	/** �޸�ҳ�� */
	public String editUI() throws Exception {
		// ׼�����Ե�����
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		return "saveUI";
	}

	/** �޸� */
	public String edit() throws Exception {
		// 1�������ݿ��л�ȡԭ����
		Role role = roleService.getById(model.getId());

		// 2������Ҫ�޸ĵ�����
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 3�����µ����ݿ�
		roleService.update(role);

		return "toList";
	}
}
