package com.revature;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.models.Department;

public class Driver {

	static DepartmentDao dd = new DepartmentHibernate();
	
	public static void main(String[] args) {
		Department d = new Department();
		d.setName("My Other Department");
		d.setMonthlyBudget(7000.00);
//		
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		
//		s.save(d);
//		
//		s.close();
		
		System.out.println(dd.add(d));
		System.out.println(dd.getAll());
		d.setMonthlyBudget(3000.0);
		dd.update(d);
		System.out.println(dd.getById(1));
	}
}
