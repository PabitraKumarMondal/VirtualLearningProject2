package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService = new StudentService();
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPage(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks = Integer.parseInt(request.getParameter("marks"));
		Student st = new Student(id, name,marks);
		String result = studentService.insert(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "INSERTION SUCCESSFULL");
		}else {
			request.setAttribute("msg", "INSERTION UNSUCCESSFULL");
		}
		return "insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateReq() {
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks = Integer.parseInt(request.getParameter("marks"));
		Student st = new Student(id, name,marks);
		String result = studentService.update(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "UPDATE SUCCESSFULL");
		}else {
			request.setAttribute("msg", "UPDATE UNSUCCESSFULL");
		}
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteReq() {
		return "delete";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Student st = new Student(id);
		String result = studentService.delete(st);
		System.out.println(st);
		if(result.equals("SUCCESS")) {
			request.setAttribute("msg", "DELETION SUCCESSFULL");
		}else {
			request.setAttribute("msg", "DELETION UNSUCCESSFULL");
		}
		return "delete";
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request) {
		List<Student> slist = studentService.getAll();
		request.setAttribute("list", slist);
		return "getAll";
	}
}
