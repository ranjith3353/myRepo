package training.java_training.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import training.java_training.dto.EmployeeDto;

public class EmployeeMapper implements RowMapper<EmployeeDto>{

	@Override
	public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new EmployeeDto(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getInt("employee_salary"), rs.getInt("dept_id"));
	}

}
