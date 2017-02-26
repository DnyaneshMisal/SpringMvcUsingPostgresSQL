package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import com.student.beans.Student;

@Component
public class StudentDaoImpl {

	private static DataSource dataSource;
	private static NamedParameterJdbcTemplate jdbcTemplate;
	private String sql = null;

	public boolean saveStudent(Student student) {

		int result = 0;
		sql = "insert into student values (:studentFirstName,:studentLname,:studentGender,:StudentAge)";
		Map<String, String> studentAttMap = new HashMap<String, String>();
		studentAttMap.put("studentFirstName", student.getFname());
		studentAttMap.put("studentLname", student.getLname());
		studentAttMap.put("studentGender", student.getGender());
		studentAttMap.put("StudentAge", student.getAge());
		result = getJdbcTemplate().update(sql, studentAttMap);
		if (result == 1)
			return true;
		else
			return false;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		System.out.println("datasource set" + dataSource);
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> retriveStudentList() {
		sql = "select * from student";
		List<Student> studList = new ArrayList<Student>();

		RowMapper rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int row) throws SQLException {

				Student student = new Student();
				student.setFname(rs.getString(1));
				student.setLname(rs.getString(2));
				student.setGender(rs.getString(3));
				student.setAge(rs.getString(4));

				return student;
			}
			

		};
		studList = getJdbcTemplate().query(sql, rowMapper);
		return studList;
		
	}

	public int updateStudent(Student studentToUpdate) {

		sql = "update student set lastname=:studLname,age=:studAge,gender=:studGender where firstname=:studFname";
		Map<String, String> studentMap = new HashMap<String, String>();
		studentMap.put("studFname", studentToUpdate.getFname());
		studentMap.put("studLname", studentToUpdate.getLname());
		studentMap.put("studAge", studentToUpdate.getAge());
		studentMap.put("studGender", studentToUpdate.getGender());
		int updateResult = getJdbcTemplate().update(sql, studentMap);
		return updateResult;
	}

	public int deleteStudent(String studentToDelete) {
		sql = "delete from student where firstname=:fname";
		Map<String, String> studentDelMap = new HashMap<String, String>();
		studentDelMap.put("fname", studentToDelete);
		int deleteResult = getJdbcTemplate().update(sql, studentDelMap);
		return deleteResult;
	}

}
