
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Stream1 extends Common {

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
		
		Stream<String> newstream = Stream.concat(list.stream(),names.stream());
//		newstream.sorted().forEach(s->out(s));
		
		

//		@Test
//		public void test2()
//		{
			List<String> ls = Stream.of("a23123","a43434","b123123","bdsffds","adfsdfa").filter(s->s.endsWith("23")).map(s->s.toUpperCase()).collect(Collectors.toList());
			ls.forEach(s->out(s));
//		}
		
	}
	
	

}
