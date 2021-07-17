package training.java_training.spring.jdbc;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCMainClass {
	
	private static Logger LOG = LoggerFactory.getLogger(JDBCMainClass.class);
	
	private static final String MAIN_CONTEXT_FILE_LOCATION = "META-INF/spring/application-context.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Spring JDBC
		ApplicationContext ctx=new ClassPathXmlApplicationContext(MAIN_CONTEXT_FILE_LOCATION);  
		try {
			
			/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	        dataSource.setUsername("system");
	        dataSource.setPassword("oracle");*/
			
			JdbcOperations dao=(JdbcOperations)ctx.getBean("edao");
			//dao.createTable();
			//int status=dao.saveEmployee(e3);  
			//System.out.println(status);
			//dao.saveEmployee(e4);
			dao.printTableContents();
			
			System.out.println("===========================================================");
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} 
	}

}
