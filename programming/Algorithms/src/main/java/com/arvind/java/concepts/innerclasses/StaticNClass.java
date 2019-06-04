package com.arvind.java.concepts.innerclasses;

public class StaticNClass {
	
	int i =10;
	private static int k = 200;
	
	public static class innerStaticClass {
		int i=0;
		static int k = 2000;
		void display() {
			System.out.println(" The i value :" + i );
			System.out.println(" The i value :" + k );
			System.out.println("The outer member value is "+ StaticNClass.k); // only static outer class variables are accessible
			}
	}

	public static void main(String[] args) {
		StaticNClass.innerStaticClass  innerClass= new StaticNClass.innerStaticClass();

		innerClass.display(); // access of outer member variable by inner class
	
		StaticNClass outerClass = new StaticNClass();
		System.out.println(outerClass.i);
		
		// access by outer class to inner class variables
		//StaticNClass.innerStaticClass.i ;//
		StaticNClass.innerStaticClass.k ;//
		System.out.println("accessing inner class variable " +innerStaticClass.k);
		
		}
}
