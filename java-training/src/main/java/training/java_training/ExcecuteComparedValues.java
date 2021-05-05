package training.java_training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import training.java_training.dto.NameDto;

public class ExcecuteComparedValues {

	public static void main(String[] args) {
		
		sortValuesUsingComparable();
		
		sortValuesByComparingValues();
		
		
	}

	private static void sortValuesUsingComparable() {
		System.out.println("Sorting using Comparable interface \n");
		List<NameDto> arrayList = new ArrayList<>();
		arrayList.add(new NameDto("Ranjith"));
		arrayList.add(new NameDto("Kumar"));
		arrayList.add(new NameDto("Shines"));
		arrayList.add(new NameDto("Chinnu"));
		arrayList.add(new NameDto("Arya"));
		
		Collections.sort(arrayList);
		
		arrayList.stream().forEach(System.out::println);
		System.out.println();
	}

	private static void sortValuesByComparingValues() {
		Map<String, String> names = new HashMap<>();
		names.put("1", "Ranjith");
		names.put("2", "Kumar");
		names.put("4", "Shines");
		names.put("3", "Chinnu");
		names.put("5", "RK");
		names.put("6", "Arya");
		
		System.out.println("Comparing by value example: \n" );
		System.out.println("Before sorting");
		names.entrySet().stream().forEach(System.out :: println);
		System.out.println();
		List<Entry<String, String>> collect = names.entrySet().stream().sorted(Map.Entry.<String, String> comparingByValue()).collect(Collectors.toList());
		System.out.println("After sorting");
		collect.stream().forEach(System.out :: println);
	}

}
