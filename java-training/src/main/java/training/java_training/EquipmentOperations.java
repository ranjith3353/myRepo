package training.java_training;

import java.util.ArrayList;
import java.util.List;

public class EquipmentOperations {

	public static void main(String[] args) {
		List<EquipmentCounts> equipmentCounts = new ArrayList<>();
		equipmentCounts.add(new EquipmentCounts("e1",1));
		equipmentCounts.add(new EquipmentCounts("e2",2));
		equipmentCounts.add(new EquipmentCounts("e1",3));
		equipmentCounts.add(new EquipmentCounts("e2",4));
		equipmentCounts.add(new EquipmentCounts("e3",5));
		
		//display count of each equipment from equipmentList
		//equipmentCounts.stream().filter(e -> e.getEquipmentId() > 3).forEach(e -> System.out.println(e.getEquipmentId()));
		
		equipmentCounts.stream().distinct().forEach(e -> checkEqmtCount(equipmentCounts, e.getEquipmentName()));
	}

	private static long checkEqmtCount(List<EquipmentCounts> equipmentCounts, String equipmentName) {
		long count = equipmentCounts.stream().filter(e -> e.getEquipmentName().equals(equipmentName)).count();
		System.out.println(equipmentName +": " + count);
		return count;
	}

}
