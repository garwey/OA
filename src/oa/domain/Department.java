package oa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

/**
 * 部门
 * 
 * @author tyg
 * 
 */
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ElementCollection(targetClass = User.class)
	@CollectionTable(name = "department_user")
	@Column(name = "users")
	@OneToMany(mappedBy = "department")
	private Set<User> users = new HashSet<User>();
	@ManyToOne
	private Department parent;
	@ElementCollection(targetClass = Department.class)
	@CollectionTable(name = "department_children")
	@Column(name = "children")
	private Set<Department> children = new HashSet<Department>();

	private String name;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
