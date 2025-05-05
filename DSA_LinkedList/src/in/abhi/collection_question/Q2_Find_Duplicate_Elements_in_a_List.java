package in.abhi.collection_question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Find Duplicate Elements in a List


public class Q2_Find_Duplicate_Elements_in_a_List {
	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(1, 2, 3, 2, 4, 5, 1);
		Set<Integer> dupicate=new HashSet<>();
		Set<Integer> seen=new HashSet<>();
		
		for(Integer num: numbers) {
			if(!seen.add(num)) {
				dupicate.add(num);
			}
		}
		System.out.println(dupicate);
	}

}
