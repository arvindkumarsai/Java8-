package com.arvind.basic.search;

public class LinearSearch {
	
	public static void linerSearch(int [] a, int searchNumber) {
		
		for(int i=0;i <= a.length-1; i++) {
			if(searchNumber== a[i]) {
				System.out.println("The index is :" + i);
			}
		}
		
	}

	public static void main(String[] args) {
		
		int a[] = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
		LinearSearch.linerSearch(a, 170);

	}

}
