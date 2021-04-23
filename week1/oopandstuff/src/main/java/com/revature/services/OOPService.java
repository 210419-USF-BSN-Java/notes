package com.revature.services;

import com.revature.interfaces.Flyable;
import com.revature.models.Animal;
import com.revature.models.Dog;

public class OOPService {

	public void usingEncapsulation() {
		Animal a1 = new Animal();
		a1.setAge(-24);
		a1.setCanFly(true);
		a1.setNumberOfFeet(-5);
		a1.setName("Bob");
		
		System.out.println(a1.getAge());
		System.out.println(a1.getName());
		System.out.println(a1.isCanFly());
		System.out.println(a1.getNumberOfFeet());
		
		System.out.println(a1);
	}
	
	public void usingInheritance(){
		Dog d = new Dog();
		d.setAge(45);
		System.out.println("Dog of age " + d.getAge() + ", moos like " + d.moo());
	}
	
	public void usingPolymorphism() {
		Animal a = new Animal();
		Dog d = new Dog();
		
		System.out.println(a.moo());
		System.out.println(d.moo());
		
		d.fetch();
		d.fetch(5);
		
		Animal a1 = new Dog();
		System.out.println("Upcasted animal moo: " + a1.moo());
		
		Animal[] animals = {a, a1};
		for(Animal ani: animals) {
			System.out.println(ani.moo());
		}
	}
	
	public void usingAbstraction() {
		Flyable f = new Animal();
		Flyable f1 = new Dog();
		System.out.println(f.fly());
		System.out.println(f1.fly());
		
	}
}
