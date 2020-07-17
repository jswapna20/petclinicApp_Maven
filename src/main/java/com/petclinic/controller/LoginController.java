   package com.petclinic.controller;
   import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.dto.Employee;
import com.petclinic.dto.VetDto;
import com.petclinic.entity.Speciality;



   @Controller
   @RequestMapping("/")
   public class LoginController{
	
		@RequestMapping("/")
		public ModelAndView login(){
			Employee emp = new Employee();
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("emp", emp);
			return mv ;		
		}
	
	@RequestMapping(value="/authEmp", method=RequestMethod.POST)
	public ModelAndView authenticate(@Valid @ModelAttribute("emp") Employee emp, BindingResult result, HttpSession session){
		if (result.hasErrors())
			return new ModelAndView("login");

		else if(emp.getUsername().equals("swapna.altekar@gmail.com")&& emp.getPassword().equals("swapna")){
			session.setAttribute("emp", emp);
			VetDto vetDto = new VetDto();
			Speciality speciality = new Speciality();
			ModelAndView mv = new ModelAndView("vetsearch");
			mv.addObject("vetDto", vetDto);
			return mv;
			}

		return new ModelAndView("login");
	}

	@RequestMapping(value="/vetsearch")
	public ModelAndView vetsearch(){
			VetDto vetDto = new VetDto();
			ModelAndView mv = new ModelAndView("vetsearch");
			mv.addObject("vetDto", vetDto);
			return mv;	
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
			session.removeAttribute("emp");
			Employee emp = new Employee();
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("emp", emp);
			return mv ;
	}
}
