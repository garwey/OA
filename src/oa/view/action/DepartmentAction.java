package oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import oa.base.BaseAction;
import oa.domain.Department;
import oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;

	/** �б� */
	public String list() throws Exception {
		List<Department> departmentList = null;
		if (parentId == null) { // ���������б�
			departmentList = departmentService.findTopList();
		} else { // �Ӳ����б�
			departmentList = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/** ɾ�� */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** ���ҳ�� */
	public String addUI() throws Exception {
		// ׼������, departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** ��� */
	public String add() throws Exception {
		// ��װ��Ϣ��������
		// Department department = new Department();
		// department.setName(name);
		// department.setDescription(description)
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);

		// ����
		departmentService.save(model);

		return "toList";
	}

	/** �޸�ҳ�� */
	public String editUI() throws Exception {
		// ׼������, departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// ׼�����Ե�����
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}

	/** �޸� */
	public String edit() throws Exception {
		// 1�������ݿ�ȡ��ԭ����
		Department department = departmentService.getById(model.getId());

		// 2������Ҫ�޸ĵ�����
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId)); // �����������ϼ�����

		// 3�����µ����ݿ���
		departmentService.update(department);

		return "toList";
	}
	// ---

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
