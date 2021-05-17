package com.revature;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.models.Department;

public class Driver {

	static DepartmentDao dd = new DepartmentHibernate();
	
	public static void main(String[] args) {
//		Department d = new Department();
//		d.setName("My Other Department");
//		d.setMonthlyBudget(7000.00);
//		
//		dd.add(d);
//		System.out.println(dd.getAll());
		
		Department d = dd.getById(1);
		
		System.out.println(d);
		
//		dd.update(d);
//		
//		d = dd.getById(1);
//		
//		System.out.println(d);
		
		
		dd.delete(d);
		
		d = dd.getById(1);
		
		System.out.println(d);
		
	}
}
