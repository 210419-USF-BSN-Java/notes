package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentHibernate implements DepartmentDao{

	@Override
	public Department add(Department d) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		d.setId((Integer) s.save(d));
		s.close();
		return d;
	}

	@Override
	public Department getById(Integer id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Department d = (Department) s.get(Department.class, id);
		return d;
	}

	@Override
	public List<Department> getAll() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		// use class name not name of table in db
		List<Department> departments = s.createQuery("FROM Department").list();
		s.close();
		return departments;
	}

	@Override
	public Integer update(Department d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Department d) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.delete(d);
		s.close();
		return 0;
	}

}
