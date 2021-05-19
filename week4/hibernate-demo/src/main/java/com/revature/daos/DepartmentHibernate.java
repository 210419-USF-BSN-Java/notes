package com.revature.daos;

import java.util.List;


import org.hibernate.Query;

import javax.persistence.TypedQuery;


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
		
//		Department d;
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//			CriteriaBuilder cb = s.getCriteriaBuilder();
//			CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
//			Root<Department> root = criteria.from(Department.class);
//			
//			Predicate predicateForId = cb.equal(root.get("id"), id);
//			Predicate predicateForName = cb.equal(root.get("name"), "My Other Department");
//			Predicate predicateForIdAndName = cb.and(predicateForId, predicateForName);
//			
//			criteria.select(root).where(predicateForIdAndName);
//			
//			d = s.createQuery(criteria).getSingleResult();
//		}
//		return d;
		
>>>>>>> 9b20aaa5a0513b4a6c52cf3673542aae51ed71a7
	}

	@Override
	public List<Department> getAll() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		// use class name not name of table in db
//		List<Department> departments = s.createQuery("FROM Department").list();
		List<Department> departments = s.createNamedQuery("getAllNq", Department.class).getResultList();
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
