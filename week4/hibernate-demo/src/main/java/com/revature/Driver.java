package com.revature;

import org.hibernate.Session;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class Driver {

	static DepartmentDao dd = new DepartmentHibernate();
	
	public static void main(String[] args) {
		Department d = new Department();
		d.setName("My Cool Department");
		d.setMonthlyBudget(99000.00);
//		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		s.save(d);
		
		s.close();
		
		dd.add(d);
//		System.out.println(dd.getById(1));
		System.out.println(dd.getAll());
	}
}
