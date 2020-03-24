package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
@Component("student")
public class StudentService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String insert(Student student) {
		String sql = "insert into student values(?,?,?)";
		int result = jdbcTemplate.update(sql, student.getId(), student.getName(), student.getMarks());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}

	}

	public String update(Student student) {
		String sql = "update student set name = ?, marks = ? where id = ?";
		int result = jdbcTemplate.update(sql, student.getName(),student.getMarks(), student.getId() );
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}

	}

	public String delete(Student student) {
		String sqlDelete = "delete from student where id = ?";
		int result = jdbcTemplate.update(sqlDelete, student.getId());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}

	}


	
	public List<Student> getAll() {
				
		String sql = "select * from student";
		List<Student> result = jdbcTemplate.query(sql,
				(rs,rowNum) -> new Student(rs.getInt(1),rs.getString(2),rs.getInt(3))
				);
		return result;
		

	}

}