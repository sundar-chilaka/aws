package demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {
	 int [] numbers = {2,1,3,5,3,2};
	 
	    Arrays.stream(numbers)
        .filter(n -> !seen.add(n)) // Filter numbers that are already in the set
        .findFirst()                // Find the first repeated number
        .ifPresent(System.out::println); 
//	 List<Integer>num = Arrays.asList(2,1,3,5,3,2);
//	 
//	 num.stream()
//	 	.filter(n -> seen.)
//	 Set<Integer>seen = new HashSet<>();
	 
//	 for(Integer i: num) {
//		 if(!dupl.add(i)) {
//			 System.out.println(i);
//		 }
//	 }
//	 	List<Integer>unic=num.stream()
//	 						//.distinct()
//	 						.
//	 						.sorted()
//	 						.collect(Collectors.toList());
//	 	
//	 	System.out.println("unic num: "+unic);
		
	}
private static 	 Set<Integer>seen = new HashSet<>();
}
