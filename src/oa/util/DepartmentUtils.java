package oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import oa.domain.Department;

public class DepartmentUtils {

	/**
	 * �����������������еĲ��ű��������ŵ�ͬһ�������з��أ������������в��ŵ����ƶ��޸��ˣ��Ա�ʾ��Ρ�
	 * 
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartments(List<Department> topList) {
		List<Department> list = new ArrayList<Department>();
		walkDepartmentTreeList(topList, "��", list);
		return list;
	}

	/**
	 * �������������ѱ������Ĳ�����Ϣ�ŵ�ָ���ļ�����
	 * 
	 * @param topList
	 */
	private static void walkDepartmentTreeList(Collection<Department> topList, String prefix, List<Department> list) {
		for (Department top : topList) {
			// ����
			Department copy = new Department(); // ʹ�ø�������Ϊԭ������Session��
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy); // �Ѹ�����ӵ�ͬһ��������

			// ����
			walkDepartmentTreeList(top.getChildren(), "��" + prefix, list); // ʹ��ȫ�ǵĿո�
		}
	}
}
