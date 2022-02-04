package com.katapios.controllers;

import com.katapios.DAO.Course;
import com.katapios.DAO.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/courses/")
public class CourseController {
	private CourseService courseService;

	@Autowired
	public void setContactService(CourseService courseService) {
		this.courseService = courseService;
	}


	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Course> courses = courseService.findAll();
		uiModel.addAttribute("courses", courses);
		return "courses/list";
	}

//adding without hack

//	@RequestMapping(value = "add", method = RequestMethod.GET)
//	public String addForm(Model uiModel) {
//		return "courses/edit";
//	}
//
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(Course course, BindingResult bindingResult, Model uiModel) {
//		if (bindingResult.hasErrors()) {
//			uiModel.addAttribute("course", course);
//			return "courses/update";
//		}
//		courseService.save(course);
//		return "redirect:/courses/";
//
//	}


	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") int id, Model uiModel) {
		uiModel.addAttribute("course", courseService.findById(id));
		return "courses/edit";
	}


	//@PreAuthorize("isAuthenticated()")
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public String update(Course course, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("course", course);
			return "courses/update";
		}
		courseService.save(course);
		return "redirect:/courses/";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(Model uiModel) {
		return "courses/edit";
	}
	//Adding new entry hack
	@RequestMapping(value = "update/0", method = RequestMethod.GET)
	public String addForm(Model uiModel) {
		return "courses/edit";
	}

	//@PreAuthorize("isAuthenticated()")
	@PreAuthorize("hasRole('ROLE_USER')")
	//@GetMapping("delete/{id}")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model uiModel) {
		if (courseService.findById(id) != null)
			courseService.delete(id);
		//		List<Course> courses = courseService.findAll();
		//		uiModel.addAttribute("courses", courses);
		//		return "courses/list";
		return "redirect:/courses/";
	}

}
