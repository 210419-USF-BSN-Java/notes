package com.revature.daos;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDao {
	public Department add(Department d);
	public Department getById(Integer id);
	public List<Department> getAll();
	public Integer update(Department d);
	public Integer delete(Department d);
}
