package training.java_training.dto;

public class NameDto implements Comparable<NameDto> {
	
	private String name;
	
	public NameDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(NameDto o) {
		String name1 = this.getName().toUpperCase();
		String name2 = o.getName().toUpperCase();
		return name1.compareTo(name2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		NameDto other = (NameDto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameDto [name=" + name + "]";
	}
	
}
