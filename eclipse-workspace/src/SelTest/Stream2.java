package SelTest;

 
import java.sql.Array;
import java.util.*;
import java.util.stream.*;

import org.testng.Assert;

public class Stream2 extends Common {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("1");
		list.add("Hoanghm");
		list.add("HaiNT");
		list.add("CuongMC");
		list.add("TienBV");
		list.add("LinhVN");
		
		Long count = list.stream().filter(s->s.startsWith("D")).count();
//		out(count);
		
//		Stream list2=  (Stream) java.util.stream.Stream.of("Ducpdb", "Hoanghm","122");
		
//		long d = d.stream().filter(u->u.add("Ducpdb", "Hoanghm","122")).count();
//		
//		out(d);
		long d = java.util.stream.Stream.of("Ducpdb", "Hoanghm","122").filter(s->s.startsWith("A")).count();
//		out(d);
		
		List<String>names=Arrays.asList("a23123","a43434","b123123","bdsffds","adfsdfa");
//		names.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->out(s));
		
		Stream<String> newstream= java.util.stream.Stream.concat(names.stream(), list.stream());
//		newstream.sorted().forEach(s->out(s));
		
		
		boolean flag = newstream.anyMatch(s->s.equalsIgnoreCase("a23123"));
//		out(flag);
		
		

		
	}

}
