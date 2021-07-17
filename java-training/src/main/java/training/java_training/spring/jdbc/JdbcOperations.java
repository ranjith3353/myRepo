package training.java_training.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import training.java_training.dto.EmployeeDto;

public class JdbcOperations {

	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	public void createTable() {
		jdbcTemplate.execute("create table Employee(employee_id int primary key, employee_name varchar(100), employee_salary int, dept_id int);");
	}
	
	public void printTableContents() throws SQLException {
		String sql = "select * from employee order by employee_id";
		
		// extract details from table using prepared statement
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		System.out.println("Table Name: "+ rsmd.getTableName(1));
		while (resultSet.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(rsmd.getColumnName(i) + " " + columnValue);
		    }
		    System.out.println("");
		}
		
		// Use RowSet to extract details from table - without creating prepared statement
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
		int columnCount = metaData.getColumnCount();
		System.out.println("Table Name: "+ metaData.getTableName(1));
		while (sqlRowSet.next()) {
		    for (int i = 1; i <= columnCount; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = sqlRowSet.getString(i);
		        System.out.print(metaData.getColumnName(i) + " " + columnValue);
		    }
		    System.out.println("");
		}

		//Use RowMapper concept to map data from table by rows.
		List<EmployeeDto> employeeDtos = jdbcTemplate.query(sql, new EmployeeMapper());
		for (EmployeeDto employeeDto : employeeDtos) {
			System.out.println(employeeDto.toString());
		}
	}
	  
	public int saveEmployee(EmployeeDto e){  
	    String query="insert into employee values('"+e.getId()+"','"+e.getName()+"',"+e.getSalary()+","+e.getDeptId()+")";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int updateEmployee(EmployeeDto e){  
	    String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int deleteEmployee(EmployeeDto e){  
	    String query="delete from employee where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
}
