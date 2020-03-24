package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;
@Repository
public interface StudentDao {

	public String insert(Student s);

	public String update(Student s);

	public String delete(int id);

	public List<Student> getAll();

}
