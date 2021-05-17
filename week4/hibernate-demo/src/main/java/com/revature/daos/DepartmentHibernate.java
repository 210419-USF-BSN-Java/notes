package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
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
		
		Department d = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			d = s.find(Department.class, id);
			
		}catch(HibernateException e) {
			
		}
		
		return d;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		// use class name not name of table in db
		List<Department> departments = s.createQuery("FROM Department").list();
		s.close();
		return departments;
	}

	@Override
	public void update(Department d) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		try{
			s.beginTransaction();
			
			d.setMonthlyBudget(5000.0);
			
			s.update("Department", d);	
			
			s.getTransaction().commit();
			
			
		}catch(HibernateException e) {
			System.out.println("Tried to update");
			
		}finally {
			s.close();
		}
		
	}

	@Override
	public void delete(Department d) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			s.beginTransaction();
			
			s.delete(d);	
			
			s.getTransaction().commit();
			
		}catch(HibernateException e) {
			
		}
	}

}
