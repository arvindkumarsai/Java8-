package com.arvind.basic.search;

public class BinarySearch {
	
	public static void sort(int a[]) {
		
	}
	
	public static int binarySearch(int a[] ,int low, int high, int searchNumber) {
		
		while(low <= high) {
			int mid= low + (high -low)/2;
			
			if(a[mid] == searchNumber){
				return mid;
			}
			if(a[mid] > searchNumber) {
				return binarySearch(a, low, mid-1, searchNumber);
			}
			else {
				
				return binarySearch(a, mid+1, high, searchNumber);
			}
			
		} 
		return -1;
		
	}
	public static void main( String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 }; 
		int result =BinarySearch.binarySearch(arr, 0, arr.length-1, 40);
		if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result);
	
	}
	
	}
