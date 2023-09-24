package SelTest;

import java.util.ArrayList;

public class JavaMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaMethod var = new JavaMethod();
//		var.getData();
		ArrayList<String> output = new ArrayList();
		output.add(var.getData());
//		System.out.println(output);
		JavaMethod2 var2 = new JavaMethod2();
		
		output.add(var2.getData2());
		for(String val: output)
		{
			System.out.println(val);
		}
		
	}
	
	public String getData()
	{
		//jSystem.out.println("test method output");
		return "test method";
	}

}
