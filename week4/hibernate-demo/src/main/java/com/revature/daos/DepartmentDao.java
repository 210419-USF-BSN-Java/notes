package com.revature.daos;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDao {
	public Department add(Department d);
	public Department getById(Integer id);
	public List<Department> getAll();
	public void update(Department d);
	public void delete(Department d);
}
