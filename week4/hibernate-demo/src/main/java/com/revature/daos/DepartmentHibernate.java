package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentHibernate implements DepartmentDao {

	@Override
	public Department add(Department d) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
		Transaction tx = s.beginTransaction();
		s.save(d);
		tx.commit();
		}
		return d;
	}

	@Override
	public Department getById(Integer id) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Department department = s.get(Department.class, id);
		// alternative way
		// (Department) s.createQuery("FROM Department D WHERE D.id = id").getSingleResult();
		s.close();

		return department;
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
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Department department = s.load(Department.class, d.getId());
		department.setMonthlyBudget(d.getMonthlyBudget());;
		s.update("Department",department);
		tx.commit();
		s.close();
		return null;
	}

	@Override
	public Integer delete(Department d) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		//Integer result = s.createQuery("DELETE FROM Department WHERE id="+d.getId()).executeUpdate();
		Transaction tx = s.beginTransaction();
		s.delete(d);
		tx.commit();
		s.close();
		
		return null;
	}

}
