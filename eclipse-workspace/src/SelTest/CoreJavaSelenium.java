package SelTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum = 5;
		String website = "test web";
		char letter = 'r';
		double dec =5.99;
		boolean myCard = true;
		
		//print anything in console
		//System.out.println(myNum+"is my number");
		//System.out.println(website);
		
		//Arrays
		/// contain 5 value
		int[] arr = new int[5];
		/// add value to array
		arr[0]=1;
		arr[4]=2;
		
		//int[] arr2 = {1,2,3,4,5,6};
		//System.out.println(arr2.length);
		
		
		//Loop
//		for(int i=0; i<arr2.length; i++) 
//		{
//		
//			//System.out.println(arr2[i]);
//			
//			
//			
//		}
		
		
		String name[]= {"test 1", "test 2", "test3"};
		
		
		for(int i=0; i<name.length; i++) 
		{
		
			//System.out.println(name[i]);
			
		}
		
		// set variable in for array
		for(String name1: name) 
		{
//			System.out.println(name1);
		}
		
		
		int[] arr2 = {1,2,3,4,5,6};
		//System.out.println(arr2.length);
//		for(int i=0; i<arr2.length; i++)
//		{
//			if(arr2[i] % 2 == 0) 
//			{
//				System.out.println(arr2[i]);
//				break; //stop process at 1st result fulfill the condidtion
//			}
//			else 
//			{
//				System.out.println(arr2[i] + "not ok");
//			}
//		}
		
		ArrayList<String> arrL = new ArrayList<String>();
		arrL.add(website);
		arrL.add("myNum");
		arrL.add("letter");
		
		for(int i=0; i<arrL.size();i++)
		{
			//System.out.println(arrL.get(i));

		}
		// Set variable to item in array list
		for(String val: arrL)
		{
			//System.out.println(val);

		}
		
		
		// check if item in array list
		//System.out.println(arrL.contains("letter"));
		
		
		//Convert array to ArrayList
		List<String> nameArrL = Arrays.asList(name);
		
		for(String valName: nameArrL)
		{
			//System.out.println(valName);

		}
		
		
		//#######string
		String s1 = "test";
		String s2 = "test";
		
		
		String s3 = new String("test 2");
		String[] arr3 = s3.split("st");
		for(int i = s3.length()-1;i>=0; i-- ) 
		{
//			System.out.println(a.trim());
//			System.out.println(s3.charAt(i));
//			System.out.println(i);

		}
		
	}

}
