package training.java_training;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.java_training.dto.EmployeeDto;
import training.java_training.oops.Abstraction;
import training.java_training.oops.AbstractionImpl;
import training.java_training.oops.InheritanceImpl;
import training.java_training.spring.jdbc.JdbcOperations;
import training.java_training.util.ProjectUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final String MAIN_CONTEXT_FILE_LOCATION = "META-INF/spring/application-context.xml";
	
    public static void main( String... args ) throws Exception
    {
    	//Display main method arguments
    	String conactArgs = "";
    	for (String string : args) {
    		conactArgs = conactArgs.concat(" ").concat(string);
		}
    	System.out.println("Main method arguments value: " + conactArgs);
    	// Abstraction
        AbstractionImpl abstractionImpl = new AbstractionImpl();
        abstractionImpl.display();
        System.out.println("===========================================================");
        
        //Inheritance (including interfaces & classes - implements & extends concept)
        InheritanceImpl inheritanceImpl = new InheritanceImpl();
        System.out.println(InheritanceImpl.OBJECT_NAME); //accessing static variable from interface
        inheritanceImpl.printDetails(); //calling overriden method from implemented interface
        //inheritanceImpl.getNumber(); //accessing overriden method from extended class
        
        
        Abstraction abstraction = new InheritanceImpl(); // parent class can hold child class and call methods from parent only
        // Parent cannot call methods from child class when parent object is referred to parent class creation.
        //Abstraction abstraction = new Abstraction(); - example only - we can't instantiate abstract class
        
        System.out.println("===========================================================");
        
        // Type Casting
        
        Object obj = new StringBuffer("Hello");
        StringBuffer sb = (StringBuffer) obj;
        System.out.println(sb);
        
        /*String s = new String("Hello");
        StringBuffer sb1 = (StringBuffer) s;*/ // this one will give us compilation error - cannot convert
        
        System.out.println("===========================================================");
        
      //Equals Hashcode
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        EmployeeDto e1 = new EmployeeDto(102,"Amit",35000);
        EmployeeDto e2 = new EmployeeDto(102,"Amit",35000);
        employeeDtos.add(e1);
        employeeDtos.add(e2);
        
        System.out.println("Is e1.equals(e2): "+ e1.equals(e2));
        
        System.out.println("e1 hashcode: "+e1.hashCode());
        System.out.println("e2 hashcode: "+e2.hashCode());
        
        System.out.println("===========================================================");
        
        //Spring JDBC
        /*ApplicationContext ctx=new ClassPathXmlApplicationContext(MAIN_CONTEXT_FILE_LOCATION);  
        
        JdbcOperations dao=(JdbcOperations)ctx.getBean("edao");  
		int status=dao.saveEmployee(e1);  
        System.out.println(status);*/
        
        System.out.println("===========================================================");
        
        
    }
}
