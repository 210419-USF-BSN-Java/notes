package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDao{

	@Override
	public Employee add(Employee e) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		e.setId((Integer) s.save(e));
		s.close();
		return e;
	}

	@Override
	public Employee getById(Integer id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Employee e = (Employee) s.get(Employee.class, id);
		s.close();
		return e;
	}

	@Override
	public List<Employee> getAll() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Employee> employees = (List<Employee>) s.createQuery("FROM Employee");
		s.close();
		return employees;
	}

	@Override
	public Integer update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Employee e) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.delete(e);
		s.close();
		return null;
	}

}
