package in.abhi.collection_question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Count Frequency of Elements in a List

public class Q3_Count_Frequency_of_Elements_in_a_List {
	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana");
		
		Map<String, Integer> freqMap=new HashMap<>();
		
		for(String item: items) {
			freqMap.put(item, freqMap.getOrDefault(item, 0)+1);
		}
		System.out.println(freqMap);
	}
	
}
