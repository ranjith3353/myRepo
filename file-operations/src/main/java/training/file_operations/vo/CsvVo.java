package training.file_operations.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CsvVo {

	private Map<String, String> keyVal;

	public CsvVo(String id) {
		keyVal = new LinkedHashMap<>();// you may also use HashMap if you don't
										// need to keep order
	}

	public Map<String, String> getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(Map<String, String> keyVal) {
		this.keyVal = keyVal;
	}

	public void put(String key, String val) {
		keyVal.put(key, val);
	}

	public String get(String key) {
		return keyVal.get(key);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyVal == null) ? 0 : keyVal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsvVo other = (CsvVo) obj;
		if (keyVal == null) {
			if (other.keyVal != null)
				return false;
		} else if (!keyVal.equals(other.keyVal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String mapDetails = "CsvVo:";
		for (Entry<String, String> entry : keyVal.entrySet()) {
			mapDetails = mapDetails.concat(" [key = "+ entry.getKey() + ", Val = " + entry.getValue() + "]\n");
		}
		return mapDetails;
	}

}
