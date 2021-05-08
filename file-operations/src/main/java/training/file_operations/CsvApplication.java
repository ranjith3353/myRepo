package training.file_operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import training.file_operations.parser.CsvParser;
import training.file_operations.vo.CsvVo;

public class CsvApplication {

	public static void main(String[] args) throws IOException {
		File csv1 = new File("src/main/resources/Dep.csv");
		File csv2 = new File("src/main/resources/emp.csv");

		List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);

		List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv2);

		List<String> allCsvHeaders = new ArrayList<>();
		allCsvHeaders.addAll(csv1Headers);
		allCsvHeaders.addAll(csv2Headers);

		Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);

		List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(csv1, csv1Headers);
		List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);

		Set<CsvVo> allCsvRecords = new HashSet<>();
		// Merge matching records
		for (CsvVo csvVo : csv1Records) {
			for (Entry<String, String> entry : csvVo.getKeyVal().entrySet()) {
				for (CsvVo csvVo2 : csv2Records) {
					for (Entry<String, String> entry2 : csvVo2.getKeyVal().entrySet()) {
						if(entry2.getKey().equals(entry.getKey())) {
							allCsvRecords.add(csvVo2);
						}
					}
				}
			}
		}

		//Sort allCsvRecords and add them into a list
		
		List<CsvVo> sortedCsvRecords = new ArrayList<>();
		for (int i = 1; i <= allCsvRecords.size(); i++) {
			for (CsvVo csvVo : allCsvRecords) {
				for (Entry<String, String> entry : csvVo.getKeyVal().entrySet()) {
					if(entry.getKey().equals("dep_id") && Integer.valueOf(entry.getValue()) == i) {
						sortedCsvRecords.add(csvVo);
					}
				}
			}
		}

		CsvParser.writeToCsv(new File("src/main/resources/file_output.csv"), uniqueHeaders, sortedCsvRecords);
		System.out.println("output file generated with records: \n" + sortedCsvRecords);
	}

}