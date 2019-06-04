package com.arvind.java.concepts.innerclasses;

public class NSCMExample {

	int i=10;
	public int j=100;
	private int k=1000;
	
	public class inner {
		int i=0;
		private int j=0;
		static final int k=0;
				
		void display() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(k);
			NSCMExample outer = new NSCMExample();
			
			System.out.println("outer variable displayed from inner method" + outer.i);
			System.out.println("outer variable displayed from inner method" + outer.j);
			System.out.println("outer variable displayed from inner method" + outer.k);
		}
	}
	public static void main(String[] args) {
		NSCMExample outer = new NSCMExample();
		NSCMExample.inner in = outer.new inner();
		
		in.display();
		
		System.out.println(inner.k);

	}

}
