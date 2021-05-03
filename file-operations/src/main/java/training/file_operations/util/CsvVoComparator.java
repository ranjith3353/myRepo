package training.file_operations.util;

import java.util.Comparator;

import training.file_operations.vo.CsvVo;

public class CsvVoComparator implements Comparator<CsvVo>{
	
	private static final String EMPLOYEE_ID = "Employee_ID";

	@Override
	public int compare(CsvVo o1, CsvVo o2) {
		System.out.println("employee-id from o1: "+ o1.get(EMPLOYEE_ID));
		System.out.println("employee-id from o2: "+ o2.get(EMPLOYEE_ID));
		boolean booleanValue = Integer.valueOf(o1.get(EMPLOYEE_ID)) > Integer.valueOf(o2.get(EMPLOYEE_ID));
		if(booleanValue)
			return booleanValue == false?0:1;
		
		return 0;
	}

}
