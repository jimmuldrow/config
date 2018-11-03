package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;

@Controller
public class StudentController {

   @RequestMapping(value = "/student/{name}", method = RequestMethod.GET)
   public ModelAndView student(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) {
	   String id = "54321";
	   HttpSession session = request.getSession();
	   session.setAttribute("id", id);
	   Student student = new Student();
	   String nm = noNull(name);
	   
	   if(!nm.equals("")){
		   student.setName(nm);
	   }
	   
      return new ModelAndView("student", "command", student);
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public ModelAndView addStudent(@ModelAttribute("SpringWeb")Student student, HttpServletRequest request, HttpServletResponse response) {
	   HttpSession session = request.getSession();
	   String id = (String) session.getAttribute("id");
	   student.setId(id);
	   return new ModelAndView("result", "command", student);
   } 
   
   private String noNull(String s){return ((s ==  null) ? "" : s.trim());}   
   
   /*
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, 
   ModelMap model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());      
      return "result";
   }
   */
   


}