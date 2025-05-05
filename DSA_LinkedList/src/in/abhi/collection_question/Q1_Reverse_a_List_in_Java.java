package in.abhi.collection_question;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Question: How do you reverse a List in Java?
public class Q1_Reverse_a_List_in_Java {
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
	}
}
