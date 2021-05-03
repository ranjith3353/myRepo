package training.java_training.oops;

/*If we implement Inheritance_interface_2 then we will get ambiguity problem because even though 
the method names are same but the return types are different.*/

public class InheritanceImpl extends Abstraction implements Inheritance_interface {

	@Override
	public void printDetails() throws RuntimeException {
		try {
			display();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	String getName() throws Exception{
		return "Ranjith";
	}

	@Override
	public String getNumber() {
		return printNumber(); // directly calling default method from
								// implemented interface
	}

}
