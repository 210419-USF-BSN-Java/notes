package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentHibernate implements DepartmentDao{

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
//		Department d;
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//		d = s.get(Department.class, id);
//		}
//		return d;
		
//		Department d;
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//			String sql = "select * from hibernate.departments where department_id = :departmentid";
//			NativeQuery<Department> nq = s.createNativeQuery(sql);
//			nq.addEntity(Department.class);
//			nq.setParameter("departmentid", id);
//			d = nq.getSingleResult();
//		}
//		return d;
		
		Department d;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			TypedQuery<Department> tq = s.createQuery("from Department where id = :departmentid", Department.class);
			tq.setParameter("departmentid", id);
			d = tq.getSingleResult();
		}
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
	public void update(Department d) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(d);
			tx.commit();
		}
	}

	@Override
	public void delete(Department d) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(d);
			tx.commit();
		}
	}

}
