package in.abhi.collection_question;

import java.util.HashMap;
import java.util.Map;

//Sort Map by Values

public class Q4_Sort_Map_by_Values {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 3);
		map.put("banana", 1);
		map.put("orange", 2);
		
		map.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue())
			.forEach(entry ->
					System.out.println(entry.getKey()+" = "+entry.getValue()));
				
	}
}
